package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
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
public class RestException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RES0000");

    public RestException() {
        super(ERROR_CODE);
    }

    public RestException(String message) {
        super(ERROR_CODE, message);
    }

    public RestException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RestException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RestException(ErrorCode errorCode) {
        super(errorCode);
    }

    public RestException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public RestException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RestException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
