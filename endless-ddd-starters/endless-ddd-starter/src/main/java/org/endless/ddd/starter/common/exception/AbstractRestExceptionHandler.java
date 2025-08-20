package org.endless.ddd.starter.common.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.common.NotFoundException;
import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.utils.error.message.exception.ExceptionErrorParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * AbstractRestAdapterExceptionHandler
 * <p>
 * create 2024/11/02 04:19
 * <p>
 * update 2024/11/02 06:56
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Slf4j
public abstract class AbstractRestExceptionHandler {

    public abstract RestResponse<Void> response();

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse<Void>> handleRestBadRequestException(NoResourceFoundException e) {
        ErrorCode errorCode = ErrorCode.of("RES0201");
        String message = ExceptionErrorParser.parse(null, errorCode, null);
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse<Void>> handleNoHandlerFoundException(NoHandlerFoundException e) {
        ErrorCode errorCode = ErrorCode.of("RES0201");
        String message = ExceptionErrorParser.parse(null, errorCode, null);
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse<Void>> handleNoHandlerFoundException(HttpRequestMethodNotSupportedException e) {
        ErrorCode errorCode = ErrorCode.of("RES0202");
        String message = ExceptionErrorParser.parse(null, errorCode, null);
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse<Void>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ErrorCode errorCode = ErrorCode.of("RES0250");
        String message = ExceptionErrorParser.parse(null, errorCode, null);
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestResponse<Void>> handleConstraintViolation(ConstraintViolationException e) {
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            Class<?> rootBeanClass = violation.getRootBeanClass(); // 参数对象类型
            String propertyPath = violation.getPropertyPath().toString(); // 出错字段路径
            String message = "";
            log.error("{}", rootBeanClass);
            log.error("{}", propertyPath);
            log.error("{}", violation.getMessage());
            log.error("[{}][{}]{}", ErrorCode.of("DTO0001").getCode(), ErrorCode.of("DTO0001").getDescription(), message, e);
            // 你可以基于这些信息做日志、定制响应等
        }
        ErrorCode errorCode = ErrorCode.of("DTO1001");
        String message = ExceptionErrorParser.parse(null, errorCode, null);
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestResponse<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            sb.append(error.getField())
                    .append(": ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }
        ErrorCode errorCode = ErrorCode.of("DTO1001");
        String message = ExceptionErrorParser.parse(null, errorCode, sb.toString().trim());
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RestResponse<Void>> handleNotFoundException(NotFoundException e) {
        log.error("[{}]{}", e.getErrorCode().getCode(), e.getMessage(), e);
        return response().notFound(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<RestResponse<Void>> handleUnknownException(UnknownException e) {
        log.error("[{}]{}", e.getErrorCode().getCode(), e.getMessage(), e);
        return response().unavailable(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(FailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestResponse<Void>> handleFailedException(FailedException e) {
        log.error("[{}]{}", e.getErrorCode().getCode(), e.getMessage(), e);
        return response().failure(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestResponse<Void>> handleException(Exception e) {
        ErrorCode errorCode = ErrorCode.of("FAILURE");
        String message = ExceptionErrorParser.parse(null, errorCode, e.getMessage());
        log.error("[{}]{}", errorCode, message, e);
        return response().failure(errorCode, message);
    }

}
