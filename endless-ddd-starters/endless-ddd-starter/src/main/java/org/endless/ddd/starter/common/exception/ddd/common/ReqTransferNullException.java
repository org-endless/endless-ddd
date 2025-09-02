package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO1000;

    public ReqTransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public ReqTransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ReqTransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ReqTransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ReqTransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ReqTransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public ReqTransferNullException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
