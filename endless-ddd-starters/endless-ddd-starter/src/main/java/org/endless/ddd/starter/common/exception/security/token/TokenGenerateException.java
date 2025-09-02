package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * TokenGenerateException
 * <p>
 * create 2024/12/24 16:52
 * <p>
 * update 2024/12/24 16:54
 *
 * @author Deng Haozhi
 * @see TokenException
 * @since 1.0.0
 */
public class TokenGenerateException extends TokenException {

    private static final ErrorCode ERROR_CODE = ErrorCode.SEC0031;

    public TokenGenerateException() {
        super(null, ERROR_CODE, null, null);
    }

    public TokenGenerateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TokenGenerateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TokenGenerateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TokenGenerateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TokenGenerateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
