package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * RestClientResponseFailedException
 * <p>
 * create 2025/08/20 23:15
 * <p>
 * update 2025/08/20 23:15
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class RestClientResponseFailedException extends RestClientFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.RES0700;

    public RestClientResponseFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestClientResponseFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestClientResponseFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestClientResponseFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestClientResponseFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestClientResponseFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
