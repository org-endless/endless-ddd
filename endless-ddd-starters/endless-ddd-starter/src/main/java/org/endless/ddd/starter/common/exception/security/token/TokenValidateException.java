package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * TokenValidateException
 * <p>
 * create 2024/12/25 13:52
 * <p>
 * update 2024/12/25 13:53
 *
 * @author Deng Haozhi
 * @see TokenException
 * @since 1.0.0
 */
public class TokenValidateException extends TokenException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0033");

    public TokenValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public TokenValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TokenValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TokenValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TokenValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TokenValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
