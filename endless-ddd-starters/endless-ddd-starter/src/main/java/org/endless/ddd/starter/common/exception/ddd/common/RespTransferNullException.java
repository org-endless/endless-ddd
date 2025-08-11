package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RespTransferNullException
 * <p>
 * create 2025/01/02 14:33
 * <p>
 * update 2025/01/02 14:34
 *
 * @author Deng Haozhi
 * @see TransferNullException
 * @since 1.0.0
 */
public class RespTransferNullException extends TransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2000");

    public RespTransferNullException() {
        super(ERROR_CODE);
    }

    public RespTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public RespTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RespTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RespTransferNullException(ErrorCode errorCode) {
        super(errorCode);
    }

    public RespTransferNullException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public RespTransferNullException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RespTransferNullException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
