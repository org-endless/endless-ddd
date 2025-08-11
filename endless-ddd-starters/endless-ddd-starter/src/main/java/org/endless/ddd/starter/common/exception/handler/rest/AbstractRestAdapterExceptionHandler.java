package org.endless.ddd.starter.common.exception.handler.rest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.common.NotFoundException;
import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

import static org.endless.ddd.starter.common.utils.model.string.StringTools.addBrackets;

/**
 * AbstractRestAdapterExceptionHandler
 * <p>
 * create 2024/11/02 04:19
 * <p>
 * update 2024/11/02 06:56
 *
 * @author Deng Haozhi
 * @see RestAdapterExceptionHandler
 * @since 1.0.0
 */
@Slf4j
public abstract class AbstractRestAdapterExceptionHandler implements RestAdapterExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse> handleRestBadRequestException(NoResourceFoundException e) {
        String message = addBrackets(e.getMessage());
        log.error("[{}][{}]{}", ErrorCode.of("RES0201").getCode(), ErrorCode.of("RES0201").getDescription(), message, e);
        return response().badRequest(ErrorCode.of("BAD_REQ").getDescription(), ErrorCode.of("RES0201"));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse> handleNoHandlerFoundException(NoHandlerFoundException e) {
        String message = addBrackets(e.getMessage());
        log.error("[{}][{}]{}", ErrorCode.of("RES0201").getCode(), ErrorCode.of("RES0201").getCode(), message, e);
        return response().badRequest(ErrorCode.of("BAD_REQ").getCode(), ErrorCode.of("RES0201"));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse> handleNoHandlerFoundException(HttpRequestMethodNotSupportedException e) {
        String message = addBrackets(e.getMessage());
        log.error("[{}][{}]{}", ErrorCode.of("RES0202").getCode(), ErrorCode.of("RES0202").getCode(), message, e);
        return response().badRequest(ErrorCode.of("BAD_REQ").getCode(), ErrorCode.of("RES0202"));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = addBrackets(e.getMessage());
        log.error("[{}][{}]{}", ErrorCode.of("RES0250").getCode(), ErrorCode.of("RES0250").getDescription(), message, e);
        return response().badRequest(ErrorCode.of("BAD_REQ").getDescription(), ErrorCode.of("RES0250"));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<RestResponse> handleHandlerMethodValidation(HandlerMethodValidationException e) {
        List<String> errorFields = e.getParameterValidationResults().stream()
                .flatMap(paramResult -> paramResult.getResolvableErrors().stream()
                        .map(error -> {
                            String className = paramResult.getMethodParameter().getContainingClass().getName();
                            String fieldName = error instanceof org.springframework.validation.FieldError fe ? fe.getField() : paramResult.getMethodParameter().getParameterName();
                            String message = error.getDefaultMessage();
                            message = "参数 " + fieldName + " 校验失败" + ": " + message;
                            log.error(" {} [validate][{}][{}]{}", className, ErrorCode.of("DTS0000").getCode(), ErrorCode.of("DTS0000").getDescription(), message);
                            return fieldName;
                        })
                ).toList();
        String errorMessage;
        if (errorFields.isEmpty()) {
            errorMessage = "参数校验失败";
        } else {
            errorMessage = "参数 " + String.join(", ", errorFields) + " 校验失败";
        }
        log.error("[{}][{}]", ErrorCode.of("DTS0000").getCode(), ErrorCode.of("DTS0000").getDescription(), e);
        return response().failure(ErrorCode.of("DTS0000").getDescription(), ErrorCode.of("DTS0000"), errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestResponse> handleConstraintViolation(ConstraintViolationException ex) {
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            Class<?> rootBeanClass = violation.getRootBeanClass(); // 参数对象类型
            String propertyPath = violation.getPropertyPath().toString(); // 出错字段路径
            String message = "";
            log.error("{}", rootBeanClass);
            log.error("{}", propertyPath);
            log.error("{}", violation.getMessage());
            log.error("[{}][{}]{}", ErrorCode.of("DTO0001").getCode(), ErrorCode.of("DTO0001").getDescription(), message, ex);
            // 你可以基于这些信息做日志、定制响应等
        }
        log.error("[{}][{}]{}", ErrorCode.of("DTO0001").getCode(), ErrorCode.of("DTO0001").getDescription(), ex);

        return response().failure(ErrorCode.of("DTO0001").getDescription(), ErrorCode.of("DTO0001"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            sb.append(error.getField())
                    .append(": ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }
        String message = addBrackets(sb.toString().trim());
        log.error("[{}][{}]{}", ErrorCode.of("DTO0001").getCode(), ErrorCode.of("DTO0001").getDescription(), message, e);
        return response().failure(ErrorCode.of("DTO0001").getDescription(), ErrorCode.of("DTO0001"), message);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RestResponse> handleNotFoundException(NotFoundException e) {
        String message = addBrackets(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        log.error("[{}]{}[{}]{}", errorCode.getCode(), e.getMethod() == null ? "" : "[" + e.getMethod() + "]", errorCode.getDescription(), message, e);
        return response().notFound(e.getMethod() == null ? errorCode.getDescription() : e.getMethod(), errorCode, message);
    }

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<RestResponse> handleUnknownException(UnknownException e) {
        String message = addBrackets(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        log.error("[{}]{}[{}]{}", errorCode.getCode(), e.getMethod() == null ? "" : "[" + e.getMethod() + "]", errorCode.getDescription(), message, e);
        return response().unavailable(e.getMethod() == null ? errorCode.getDescription() : e.getMethod(), errorCode, message);
    }

    @ExceptionHandler(FailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestResponse> handleFailedException(FailedException e) {
        String message = addBrackets(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        log.error("[{}]{}[{}]{}", errorCode.getCode(), e.getMethod() == null ? "" : "[" + e.getMethod() + "]", errorCode.getDescription(), message, e);
        return response().failure(e.getMethod() == null ? errorCode.getDescription() : e.getMethod(), errorCode, message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestResponse> handleException(Exception e) {
        String message = addBrackets(e.getMessage());
        log.error("[{}][{}]{}", ErrorCode.of("FAILURE").getCode(), ErrorCode.of("FAILURE").getDescription(), message, e);
        return response().failure(ErrorCode.of("FAILURE").getDescription(), ErrorCode.of("FAILURE"), message);
    }
}
