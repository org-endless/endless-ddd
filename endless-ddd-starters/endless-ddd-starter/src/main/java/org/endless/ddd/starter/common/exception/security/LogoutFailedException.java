package org.endless.ddd.starter.common.exception.security;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * LogoutFailedException
 * <p>
 * create 2024/12/19 16:57
 * <p>
 * update 2024/12/19 16:57
 *
 * @author Deng Haozhi
 * @see SecurityFailedException
 * @since 1.0.0
 */
public class LogoutFailedException extends SecurityFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0020");

    public LogoutFailedException() {
        super(ERROR_CODE);
    }

    public LogoutFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public LogoutFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public LogoutFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
