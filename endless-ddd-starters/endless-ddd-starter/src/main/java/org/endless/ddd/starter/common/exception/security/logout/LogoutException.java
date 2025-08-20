package org.endless.ddd.starter.common.exception.security.logout;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.SecurityException;

/**
 * LogoutFailedException
 * <p>
 * create 2024/12/19 16:57
 * <p>
 * update 2024/12/19 16:57
 *
 * @author Deng Haozhi
 * @see SecurityException
 * @since 1.0.0
 */
public class LogoutException extends SecurityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0040");

    public LogoutException() {
        super(null, ERROR_CODE, null, null);
    }

    public LogoutException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public LogoutException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public LogoutException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public LogoutException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public LogoutException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
