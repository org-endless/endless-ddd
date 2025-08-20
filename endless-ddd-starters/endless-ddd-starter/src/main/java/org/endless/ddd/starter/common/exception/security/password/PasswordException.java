package org.endless.ddd.starter.common.exception.security.password;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.SecurityException;

/**
 * PasswordException
 * <p>
 * create 2025/08/21 04:04
 * <p>
 * update 2025/08/21 04:05
 *
 * @author Deng Haozhi
 * @see SecurityException
 * @since 1.0.0
 */
public class PasswordException extends SecurityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0010");

    public PasswordException() {
        super(null, ERROR_CODE, null, null);
    }

    public PasswordException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PasswordException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PasswordException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PasswordException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PasswordException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public PasswordException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
