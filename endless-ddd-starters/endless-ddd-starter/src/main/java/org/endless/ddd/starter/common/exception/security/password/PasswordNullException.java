package org.endless.ddd.starter.common.exception.security.password;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * UsernameNullException
 * <p>
 * create 2025/01/22 15:01
 * <p>
 * update 2025/01/22 15:03
 *
 * @author Deng Haozhi
 * @see PasswordException
 * @since 1.0.0
 */
public class PasswordNullException extends PasswordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0021");

    public PasswordNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public PasswordNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PasswordNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PasswordNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PasswordNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PasswordNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
