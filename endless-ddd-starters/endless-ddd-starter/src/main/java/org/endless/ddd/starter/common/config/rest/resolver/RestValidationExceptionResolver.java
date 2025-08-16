package org.endless.ddd.starter.common.config.rest.resolver;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.config.rest.RestException;
import org.endless.ddd.starter.common.exception.handler.rest.RestAdapterExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.endless.ddd.starter.common.config.endless.constant.EndlessConstant.JSON_ALLOWED_TYPES;

/**
 * RestValidationExceptionResolver
 * <p>
 * create 2025/08/17 03:29
 * <p>
 * update 2025/08/17 04:22
 *
 * @author Deng Haozhi
 * @see HandlerExceptionResolver
 * @since 1.0.0
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestValidationExceptionResolver implements HandlerExceptionResolver {

    private final RestAdapterExceptionHandler restAdapterExceptionHandler;

    private final String charset;

    public RestValidationExceptionResolver(RestAdapterExceptionHandler restAdapterExceptionHandler, EndlessProperties properties) {
        this.restAdapterExceptionHandler = restAdapterExceptionHandler;
        this.charset = properties.charset().getCode();
    }

    @Override
    public ModelAndView resolveException(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, Object handler, @NonNull Exception e) {
        if (e instanceof HandlerMethodValidationException handlerMethodValidationException) {
            return resolveResponse(response, resolveHandlerMethodValidationException(handlerMethodValidationException));
        }
        return null;
    }

    private ResponseEntity<RestResponse> resolveHandlerMethodValidationException(HandlerMethodValidationException e) {
        List<String> errorFields = e.getParameterValidationResults().stream()
                .flatMap(paramResult -> paramResult.getResolvableErrors().stream()
                        .map(error -> {
                            String className = paramResult.getMethodParameter().getContainingClass().getName();
                            String fieldName = error instanceof org.springframework.validation.FieldError fe ? fe.getField() : paramResult.getMethodParameter().getParameterName();
                            String message = error.getDefaultMessage();
                            message = "参数 " + fieldName + " 校验失败" + ": " + message;
                            log.error(" {} [validate][{}][{}]{}", className, ErrorCode.of("RES0251").getCode(), ErrorCode.of("RES0251").getDescription(), message);
                            return fieldName;
                        })
                ).toList();
        String errorMessage;
        if (errorFields.isEmpty()) {
            errorMessage = "参数校验失败";
        } else {
            errorMessage = "参数 " + String.join(", ", errorFields) + " 校验失败";
        }
        log.error("[{}][{}]", ErrorCode.of("RES0251").getCode(), ErrorCode.of("RES0251").getDescription(), e);
        return restAdapterExceptionHandler.response().failure(ErrorCode.of("RES0251").getDescription(), ErrorCode.of("RES0251"), errorMessage);
    }

    private ModelAndView resolveResponse(@NonNull HttpServletResponse response, ResponseEntity<RestResponse> responseEntity) {
        response.setCharacterEncoding(charset);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String json;
        response.setStatus(responseEntity.getStatusCode().value());
        json = JSON.toJSONString(responseEntity.getBody(), JSONReader.autoTypeFilter(JSON_ALLOWED_TYPES), JSONWriter.Feature.PrettyFormat);
        try (PrintWriter writer = response.getWriter()) {
            writer.write(json);
        } catch (IOException ex) {
            throw new RestException(ex);
        }
        return new ModelAndView();
    }
}
