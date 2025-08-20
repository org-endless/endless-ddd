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
        super(null, ERROR_CODE, null, null);
    }

    public TransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public TransferValidateException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
