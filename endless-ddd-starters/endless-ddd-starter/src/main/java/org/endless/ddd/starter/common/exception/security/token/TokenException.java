package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.SecurityException;

/**
 * TokenBadRequestException
 * <p>
 * create 2024/12/06 00:26
 * <p>
 * update 2024/12/06 00:27
 *
 * @author Deng Haozhi
 * @see SecurityException
 * @since 1.0.0
 */
public class TokenException extends SecurityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0030");

    public TokenException() {
        super(null, ERROR_CODE, null, null);
    }

    public TokenException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TokenException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TokenException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TokenException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TokenException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public TokenException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
