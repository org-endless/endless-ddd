package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("FAILURE");

    public FailedException() {
        super(ERROR_CODE);
    }

    public FailedException(String message) {
        super(ERROR_CODE, message);
    }

    public FailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public FailedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public FailedException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public FailedException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public FailedException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
