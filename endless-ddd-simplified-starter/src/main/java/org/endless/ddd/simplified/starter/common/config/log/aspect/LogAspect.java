package org.endless.ddd.simplified.starter.common.config.log.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.config.LogException;
import org.endless.ddd.simplified.starter.common.model.common.Transfer;
import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.domain.type.BaseEnum;
import org.endless.ddd.simplified.starter.common.model.domain.value.Value;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;
import org.endless.ddd.simplified.starter.common.utils.time.TimeStamp;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LogAspect
 * <p>
 * create 2024/11/10 07:28
 * <p>
 * update 2024/11/10 07:28
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Slf4j
@Aspect
public class LogAspect {

    private static final Set<String> SENSITIVE_KEYS = Stream.of("password", "passcode", "pwd", "secret")
            .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

    @Around("@annotation(annotation)")
    public Object logging(ProceedingJoinPoint joinPoint, Log annotation) throws Throwable {
        long start = TimeStamp.now();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String message = annotation.message();
        String value = annotation.value();

        // 处理默认值
        if (!StringUtils.hasText(message)) {
            message = methodName;
        }
        if (!StringUtils.hasText(value)) {
            value = Arrays.stream(args)
                    .map(this::maskSensitiveData)  // 处理敏感信息
                    .collect(Collectors.joining(", "));
        } else {
            String result;
            try {
                ExpressionParser parser = new SpelExpressionParser();
                StandardEvaluationContext context = new StandardEvaluationContext();
                context.setVariables(fieldsMap(joinPoint));
                Object evaluatedValue = parser.parseExpression(value).getValue(context);
                if (evaluatedValue != null) {
                    result = evaluatedValue instanceof String ? (String) evaluatedValue : evaluatedValue.toString();
                } else {
                    result = "";
                }
            } catch (Exception e) {
                throw new LogException("Spring EL表达式解析失败: " + e.getMessage(), e);
            }
            value = maskSensitiveData(result);
        }
        // 动态日志输出
        logExecutionStart(className, message, annotation.level());
        logExecutionRequestInfo(className, value, annotation.level());

        Object result = null;
        boolean isSuccess = false;
        try {
            result = joinPoint.proceed();
            isSuccess = true;
        } finally {
            long duration = TimeStamp.between(start, TimeStamp.now());
            logExecutionEnd(isSuccess, className, message, result, duration, annotation.level());
        }
        return result;
    }

    private void logExecutionStart(String className, String message, LogLevel level) {
        if (level == LogLevel.TRACE && log.isTraceEnabled()) {
            log.trace("[{}][开始执行]<{}>", className, message);
        } else if (level == LogLevel.DEBUG && log.isDebugEnabled()) {
            log.debug("[{}][开始执行]<{}>", className, message);
        } else if (log.isInfoEnabled()) {
            log.info("[{}][开始执行]<{}>", className, message);
        }
    }

    private void logExecutionRequestInfo(String className, String value, LogLevel level) {
        if (level == LogLevel.TRACE && log.isTraceEnabled()) {
            log.trace("[{}]<请求信息> {}", className, value);
        } else if (log.isDebugEnabled()) {
            log.debug("[{}]<请求信息> {}", className, value);
        }
    }

    private void logExecutionEnd(Boolean isSuccess, String className, String message, Object result, long duration, LogLevel level) {
        String resultMessage = isSuccess ? "成功" : "失败";
        if (level == LogLevel.TRACE && log.isTraceEnabled()) {
            log.trace("[{}]<{}>[执行{}，耗时: {} 毫秒]", className, message, resultMessage, duration);
            log.trace("[{}]<响应信息> {}", className, maskSensitiveData(result));
        } else {
            if (level == LogLevel.DEBUG) {
                log.debug("[{}]<{}>[执行{}，耗时: {} 毫秒]", className, message, resultMessage, duration);
            } else if (log.isInfoEnabled()) {
                log.info("[{}]<{}>[执行{}，耗时: {} 毫秒]", className, message, resultMessage, duration);
            }
            if (log.isDebugEnabled()) {
                log.debug("[{}]<响应信息> {}", className, maskSensitiveData(result));
            }
        }
    }

    /**
     * 处理敏感信息
     *
     * @param field 字段
     * @return {@link String }
     */
    private String maskSensitiveData(Object field) {
        if (field == null) {
            return "null";
        }
        if (field instanceof Map<?, ?> originalMap) {
            Map<String, Object> maskedMap = new HashMap<>();
            originalMap.forEach((key, value) ->
                    maskedMap.put(key.toString(), isSensitiveKey(key.toString()) ? "******" : maskSensitiveData(value)));
            return maskedMap.toString();
        } else if (field instanceof List<?> list) {
            return list.stream()
                    .map(this::maskSensitiveData)  // 对每个元素进行敏感数据处理
                    .toList().toString();
        } else if (field instanceof Set<?> set) {
            return set.stream()
                    .map(this::maskSensitiveData)  // 对每个元素进行敏感数据处理
                    .collect(Collectors.toSet()).toString();
        } else if (field instanceof String && containsSensitiveWord((String) field)) {
            return "******";
        } else if (field instanceof Entity || field instanceof DataRecord || field instanceof Value
                || field instanceof BaseEnum || field instanceof Transfer) {
            return maskObjectFields(field);
        }
        return field.toString();
    }

    /**
     * 使用反射获取对象的字段，检查是否为敏感信息
     *
     * @param object 对象
     * @return {@link String }
     */
    private String maskObjectFields(Object object) {
        if (object == null) {
            return "null"; // 处理null情况
        }
        try {
            Field[] fields = object.getClass().getDeclaredFields(); // 获取对象所有字段
            for (Field field : fields) {
                field.setAccessible(true); // 设置字段可访问
                Object fieldValue = field.get(object); // 获取字段值

                // 如果字段值不为空且是敏感字段，进行替换
                if (fieldValue != null && isSensitiveKey(field.getName())) {
                    field.set(object, "******"); // 替换为"******"
                } else if (fieldValue instanceof String) {
                    if (containsSensitiveWord((String) fieldValue)) {
                        field.set(object, "******"); // 替换为"******"
                    }
                }
            }
        } catch (Exception e) {
            log.error("无法访问对象字段: {}", object.getClass().getName(), e); // 如果处理字段时发生异常，记录日志
        }
        // 返回一个有意义的字符串表示，而非直接调用toString()
        return object.toString();
    }

    /**
     * 判断是否为敏感信息的字段
     *
     * @param fieldName 字段名
     * @return boolean
     */
    private boolean isSensitiveKey(String fieldName) {
        return SENSITIVE_KEYS.contains(fieldName.toLowerCase());
    }

    /**
     * 检查字段值是否包含敏感词
     *
     * @param fieldValue 字段值
     * @return boolean
     */
    private boolean containsSensitiveWord(String fieldValue) {
        String lowerStr = fieldValue.toLowerCase();
        return SENSITIVE_KEYS.stream().anyMatch(lowerStr::contains);
    }

    /**
     * 获取方法参数的 Map
     *
     * @param joinPoint 切入点
     * @return {@link Map }<{@link String }, {@link Object }>
     */
    private Map<String, Object> fieldsMap(ProceedingJoinPoint joinPoint) {
        Map<String, Object> params = new HashMap<>();
        Object[] args = joinPoint.getArgs();
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < args.length; i++) {
            params.put(names[i], args[i]);
        }
        return params;
    }
}
