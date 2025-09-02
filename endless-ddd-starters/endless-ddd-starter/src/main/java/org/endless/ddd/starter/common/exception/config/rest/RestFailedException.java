package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * RestException
 * <p>
 * create 2024/09/08 19:49
 * <p>
 * update 2025/08/10 21:41
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RestFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.RES0000;

    public RestFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RestFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
