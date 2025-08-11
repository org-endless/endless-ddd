package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RestResponseException
 * <p>
 * create 2025/03/19 16:53
 * <p>
 * update 2025/03/19 16:53
 *
 * @author Deng Haozhi
 * @see RestException
 * @since 1.0.0
 */
public class RestResponseException extends RestException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RES0020");

    public RestResponseException() {
        super(ERROR_CODE);
    }

    public RestResponseException(String message) {
        super(ERROR_CODE, message);
    }

    public RestResponseException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RestResponseException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RestResponseException(ErrorCode errorCode) {
        super(errorCode);
    }

    public RestResponseException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public RestResponseException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RestResponseException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
