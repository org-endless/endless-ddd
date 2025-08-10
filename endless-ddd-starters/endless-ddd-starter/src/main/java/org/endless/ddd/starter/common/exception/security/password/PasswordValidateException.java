package org.endless.ddd.starter.common.exception.security.password;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * PasswordValidateException
 * <p>
 * create 2025/01/25 06:06
 * <p>
 * update 2025/01/25 06:06
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class PasswordValidateException extends SecurityFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC0004;

    public PasswordValidateException() {
        super(ERROR_CODE);
    }

    public PasswordValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public PasswordValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public PasswordValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
