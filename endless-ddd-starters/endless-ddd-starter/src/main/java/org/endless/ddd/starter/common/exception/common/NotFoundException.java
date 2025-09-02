package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * FailedException
 * <p>
 * create 2024/12/05 02:08
 * <p>
 * update 2025/01/27 03:57
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class NotFoundException extends AbstractException {

    private static final ErrorCode ERROR_CODE = ErrorCode.NOT_FND;

    public NotFoundException() {
        super(ERROR_CODE);
    }

    public NotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public NotFoundException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public NotFoundException(String method, String message) {
        super(method, ERROR_CODE, message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public NotFoundException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public NotFoundException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
