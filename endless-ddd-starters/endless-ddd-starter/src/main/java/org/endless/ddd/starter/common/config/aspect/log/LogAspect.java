package org.endless.ddd.starter.common.config.aspect.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.AbstractException;
import org.endless.ddd.starter.common.exception.config.log.LogException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.ddd.starter.common.utils.model.time.TimeStampTools;
import org.springframework.core.annotation.Order;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
@Order
public class LogAspect {

    @Around("execution(* *.*(..)) && @annotation(annotation)")
    public Object logging(ProceedingJoinPoint joinPoint, Log annotation) throws Throwable {
        long start = TimeStampTools.now();
        String className = joinPoint.getSignature().getDeclaringTypeName(); // 获取类名
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String message = annotation.message();
        String value = annotation.value();

        if (!StringUtils.hasText(message)) {
            message = methodName;
        }
        if (!StringUtils.hasText(value)) {
            value = "(" + Arrays.stream(args)
                    .map(ObjectTools::maskSensitive)  // 处理敏感信息
                    .collect(Collectors.joining(", ")) + ")";
        } else {
            String result;
            try {
                ExpressionParser parser = new SpelExpressionParser();
                StandardEvaluationContext context = new StandardEvaluationContext();
                context.setVariables(fieldsMap(joinPoint));
                Object evaluatedValue = parser.parseExpression(value).getValue(context);
                if (evaluatedValue != null) {
                    result = ObjectTools.maskSensitive(evaluatedValue);
                } else {
                    result = "";
                }
            } catch (Exception e) {
                throw new LogException("Spring EL表达式解析失败: " + e.getMessage(), e);
            }
            value = result;
        }
        // 动态日志输出
        logExecutionStart(className, message, annotation.level());
        logExecutionRequestInfo(className, message, value, annotation.level());

        Object result = null;
        boolean isSuccess = false;
        try {
            result = joinPoint.proceed();
            isSuccess = true;
        } catch (AbstractException e) {
            throw e.put(message + "执行失败");
        } catch (Exception e) {
            throw new AbstractException(ErrorCode.of("FAILURE"), e.getMessage(), e).put(message + "执行失败");
        } finally {
            long duration = TimeStampTools.between(start, TimeStampTools.now());
            logExecutionEnd(isSuccess, className, message, ObjectTools.maskSensitive(result), duration, annotation.level());
        }
        return result;
    }

    private void logExecutionStart(String className, String message, LogLevel level) {
        if (level == LogLevel.TRACE) {
            if (log.isTraceEnabled()) {
                log.trace("[{}][开始执行][{}]", className, message);
            }
        } else if (level == LogLevel.DEBUG) {
            if (log.isDebugEnabled()) {
                log.debug("[{}][开始执行][{}]", className, message);
            }
        } else if (log.isInfoEnabled()) {
            log.info("[{}][开始执行][{}]", className, message);
        }
    }

    private void logExecutionRequestInfo(String className, String message, String value, LogLevel level) {
        if (level == LogLevel.TRACE) {
            if (log.isTraceEnabled()) {
                log.trace("[{}][{}]<请求信息> {}", className, message, value);
            }
        } else if (log.isDebugEnabled()) {
            log.debug("[{}][{}]<请求信息> {}", className, message, value);
        }
    }

    private void logExecutionEnd(Boolean isSuccess, String className, String message, String result, long duration, LogLevel level) {
        String resultMessage = isSuccess ? "成功" : "失败";
        if (isSuccess) {
            if (level == LogLevel.TRACE) {
                if (log.isTraceEnabled()) {
                    log.trace("[{}][{}][执行{}，耗时: {} 毫秒]", className, message, resultMessage, duration);
                    log.trace("[{}][{}]<响应信息> {}", className, message, result);
                }
            } else {
                if (level == LogLevel.DEBUG) {
                    if (log.isDebugEnabled()) {
                        log.debug("[{}][{}][执行{}，耗时: {} 毫秒]", className, message, resultMessage, duration);
                    }
                } else if (log.isInfoEnabled()) {
                    log.info("[{}][{}][执行{}，耗时: {} 毫秒]", className, message, resultMessage, duration);
                }
                if (log.isDebugEnabled()) {
                    log.debug("[{}][{}]<响应信息> {}", className, message, result);
                }
            }
        } else {
            log.error("[{}][{}][执行失败，耗时: {} 毫秒]", className, message, duration);
            log.error("[{}][{}]<响应信息> {}", className, message, result);
        }
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
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] names = signature.getParameterNames();
        if (names != null && args != null && names.length == args.length) {
            for (int i = 0; i < args.length; i++) {
                if (names[i] != null) {
                    params.put(names[i], args[i]);
                } else {
                    params.put("param" + i, args[i]);
                }
            }
        }
        return params;
    }
}
