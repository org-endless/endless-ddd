package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RestClientFailedException
 * <p>
 * create 2025/08/20 23:12
 * <p>
 * update 2025/08/20 23:12
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class RestClientFailedException extends RestFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RES0500");

    public RestClientFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestClientFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestClientFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestClientFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestClientFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestClientFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RestClientFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
