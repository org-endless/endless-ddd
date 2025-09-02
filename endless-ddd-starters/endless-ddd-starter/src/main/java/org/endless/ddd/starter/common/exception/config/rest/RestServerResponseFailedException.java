package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * RestResponseException
 * <p>
 * create 2025/03/19 16:53
 * <p>
 * update 2025/03/19 16:53
 *
 * @author Deng Haozhi
 * @see RestServerFailedException
 * @since 1.0.0
 */
public class RestServerResponseFailedException extends RestServerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.RES0300;

    public RestServerResponseFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestServerResponseFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestServerResponseFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestServerResponseFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestServerResponseFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestServerResponseFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
