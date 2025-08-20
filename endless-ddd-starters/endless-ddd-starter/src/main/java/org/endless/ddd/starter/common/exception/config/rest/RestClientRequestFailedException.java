package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RestClientRequestFailedException
 * <p>
 * create 2025/08/20 23:15
 * <p>
 * update 2025/08/20 23:15
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class RestClientRequestFailedException extends RestClientFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RES0600");

    public RestClientRequestFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestClientRequestFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestClientRequestFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestClientRequestFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestClientRequestFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestClientRequestFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
