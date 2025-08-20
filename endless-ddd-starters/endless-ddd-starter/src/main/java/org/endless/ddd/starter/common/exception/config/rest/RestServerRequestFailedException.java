package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RestRequestException
 * <p>
 * create 2025/08/10 22:33
 * <p>
 * update 2025/08/11 18:51
 *
 * @author Deng Haozhi
 * @see RestServerFailedException
 * @since 1.0.0
 */
public class RestServerRequestFailedException extends RestServerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RES0200");

    public RestServerRequestFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestServerRequestFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestServerRequestFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestServerRequestFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestServerRequestFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestServerRequestFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
