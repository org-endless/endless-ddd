package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * FailedException
 * <p>
 * create 2024/12/05 02:08
 * <p>
 * update 2025/01/27 03:57
 * update 2025/03/01 23:27
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class FailedException extends AbstractException {

    private static final ErrorCode ERROR_CODE = ErrorCode.FAILURE;

    public FailedException() {
        super(ERROR_CODE);
    }

    public FailedException(String message) {
        super(ERROR_CODE, message);
    }

    public FailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FailedException(String method, String message) {
        super(method, ERROR_CODE, message);
    }

    public FailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public FailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public FailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
