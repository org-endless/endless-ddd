package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * TransferNullException
 * <p>
 * create 2025/08/11 18:57
 * <p>
 * update 2025/08/11 18:57
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class TransferNullException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO0000;

    public TransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public TransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public TransferNullException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
