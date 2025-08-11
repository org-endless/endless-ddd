package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO0000");

    public TransferNullException() {
        super(ERROR_CODE);
    }

    public TransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public TransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public TransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public TransferNullException(ErrorCode errorCode) {
        super(errorCode);
    }

    public TransferNullException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public TransferNullException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public TransferNullException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
