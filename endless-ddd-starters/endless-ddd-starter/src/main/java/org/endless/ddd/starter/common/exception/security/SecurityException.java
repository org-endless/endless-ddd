package org.endless.ddd.starter.common.exception.security;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * SecurityException
 * <p>
 * create 2024/12/05 18:10
 * <p>
 * update 2024/12/31 23:39
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class SecurityException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0000");

    public SecurityException() {
        super(null, ERROR_CODE, null, null);
    }

    public SecurityException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SecurityException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SecurityException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SecurityException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SecurityException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public SecurityException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
