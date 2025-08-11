package org.endless.ddd.starter.common.exception.handler.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.security.access.AccessDeniedException;

/**
 * AbstractSecurityExceptionHandler
 * <p>
 * create 2025/07/19 05:34
 * <p>
 * update 2025/07/19 05:34
 *
 * @author Deng Haozhi
 * @see RestAdapterExceptionHandler
 * @since 1.0.0
 */
@Slf4j
@ConditionalOnClass(AccessDeniedException.class)
public abstract class AbstractSecurityExceptionHandler implements RestAdapterExceptionHandler {

    // @ExceptionHandler(AuthorizationDeniedException.class)
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // public ResponseEntity<RestResponse> handleAuthorizationDeniedException(AuthorizationDeniedException e) {
    //     String message = addBrackets("没有访问权限");
    //     log.error("[{}][{}]{}", ErrorCode.FORBIDN.getCode(), ErrorCode.FORBIDN.getDescription(), message, e);
    //     return response().forbidden(ErrorCode.FORBIDN, message);
    // }
    //
    // @ExceptionHandler(SecurityUnknownException.class)
    // @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    // public ResponseEntity<RestResponse> handleSecurityUnknownException(SecurityUnknownException e) {
    //     String message = addBrackets(e.getMessage());
    //     ErrorCode errorCode = e.getErrorCode();
    //     log.error("[{}][{}]{}", errorCode.getCode(), errorCode.getDescription(), message, e);
    //     return response().unavailable(errorCode, message);
    // }
    //
    // @ExceptionHandler(SecurityFailedException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // public ResponseEntity<RestResponse> handleSecurityFailedException(SecurityFailedException e) {
    //     String message = addBrackets(e.getMessage());
    //     ErrorCode errorCode = e.getErrorCode();
    //     log.error("[{}][{}]{}", errorCode.getCode(), errorCode.getDescription(), message, e);
    //     return response().failure(errorCode, message);
    // }
}
