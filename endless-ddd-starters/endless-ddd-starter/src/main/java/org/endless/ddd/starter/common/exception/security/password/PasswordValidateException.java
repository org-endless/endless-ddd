package org.endless.ddd.starter.common.exception.security.password;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * PasswordValidateException
 * <p>
 * create 2025/01/25 06:06
 * <p>
 * update 2025/01/25 06:06
 *
 * @author Deng Haozhi
 * @see PasswordException
 * @since 1.0.0
 */
public class PasswordValidateException extends PasswordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC0022;

    public PasswordValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public PasswordValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PasswordValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PasswordValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PasswordValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PasswordValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
