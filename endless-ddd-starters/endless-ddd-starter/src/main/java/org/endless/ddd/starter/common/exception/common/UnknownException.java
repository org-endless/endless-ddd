package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * UnknownException
 * <p>
 * create 2024/12/05 02:05
 * <p>
 * update 2024/12/05 02:07
 * update 2025/07/19 02:56
 * update 2025/08/11 19:49
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class UnknownException extends AbstractException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UNKNOWN");

    public UnknownException() {
        super(ERROR_CODE);
    }

    public UnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public UnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public UnknownException(String method, String message) {
        super(method, ERROR_CODE, message);
    }

    public UnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public UnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public UnknownException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
