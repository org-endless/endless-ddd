package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * TokenRefreshException
 * <p>
 * create 2024/12/25 18:36
 * <p>
 * update 2024/12/25 18:47
 *
 * @author Deng Haozhi
 * @see TokenException
 * @since 1.0.0
 */
public class TokenRefreshException extends TokenException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC0032;

    public TokenRefreshException() {
        super(null, ERROR_CODE, null, null);
    }

    public TokenRefreshException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TokenRefreshException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TokenRefreshException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TokenRefreshException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TokenRefreshException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
