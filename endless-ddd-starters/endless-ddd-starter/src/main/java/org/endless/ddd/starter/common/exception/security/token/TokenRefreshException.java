package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * TokenRefreshException
 * <p>
 * create 2024/12/25 18:36
 * <p>
 * update 2024/12/25 18:47
 *
 * @author Deng Haozhi
 * @see SecurityFailedException
 * @since 1.0.0
 */
public class TokenRefreshException extends SecurityFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC0012;

    public TokenRefreshException() {
        super(ERROR_CODE);
    }

    public TokenRefreshException(String message) {
        super(ERROR_CODE, message);
    }

    public TokenRefreshException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public TokenRefreshException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
