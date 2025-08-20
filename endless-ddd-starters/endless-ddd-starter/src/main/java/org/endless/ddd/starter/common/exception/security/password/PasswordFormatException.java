package org.endless.ddd.starter.common.exception.security.password;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * PasswordValidateException
 * <p>
 * create 2025/01/25 06:06
 * <p>
 * update 2025/08/21 03:54
 *
 * @author Deng Haozhi
 * @see PasswordException
 * @since 1.0.0
 */
public class PasswordFormatException extends PasswordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0023");

    public PasswordFormatException() {
        super(null, ERROR_CODE, null, null);
    }

    public PasswordFormatException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PasswordFormatException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PasswordFormatException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PasswordFormatException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PasswordFormatException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
