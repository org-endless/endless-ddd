package org.endless.ddd.starter.common.exception.security.username;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.SecurityException;

/**
 * UsernameNullException
 * <p>
 * create 2025/01/22 15:01
 * <p>
 * update 2025/01/22 15:03
 *
 * @author Deng Haozhi
 * @see SecurityException
 * @since 1.0.0
 */
public class UsernameNullException extends SecurityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC0011;

    public UsernameNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public UsernameNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public UsernameNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public UsernameNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public UsernameNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public UsernameNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
