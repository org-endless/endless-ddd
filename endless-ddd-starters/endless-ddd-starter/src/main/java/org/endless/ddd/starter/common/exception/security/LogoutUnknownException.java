package org.endless.ddd.starter.common.exception.security;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityUnknownException;

/**
 * LogoutUnknownException
 * <p>
 * create 2024/12/19 16:54
 * <p>
 * update 2024/12/19 16:54
 *
 * @author Deng Haozhi
 * @see SecurityUnknownException
 * @since 1.0.0
 */
public class LogoutUnknownException extends SecurityUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC9020;

    public LogoutUnknownException() {
        super(ERROR_CODE);
    }

    public LogoutUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public LogoutUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public LogoutUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
