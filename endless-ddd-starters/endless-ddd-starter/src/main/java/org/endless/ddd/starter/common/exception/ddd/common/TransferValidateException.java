package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * TransferValidateException
 * <p>
 * create 2025/01/02 14:30
 * <p>
 * update 2025/01/02 14:31
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class TransferValidateException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO0001");

    public TransferValidateException() {
        super(ERROR_CODE);
    }

    public TransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public TransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public TransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public TransferValidateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public TransferValidateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public TransferValidateException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public TransferValidateException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
