package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * ReqTransferNullException
 * <p>
 * create 2025/01/02 14:18
 * <p>
 * update 2025/08/11 19:10
 *
 * @author Deng Haozhi
 * @see TransferNullException
 * @since 1.0.0
 */
public class ReqTransferNullException extends TransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1000");

    public ReqTransferNullException() {
        super(ERROR_CODE);
    }

    public ReqTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public ReqTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ReqTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public ReqTransferNullException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ReqTransferNullException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ReqTransferNullException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public ReqTransferNullException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
