package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * ReqTransferValidateException
 * <p>
 * create 2025/08/11 19:13
 * <p>
 * update 2025/08/11 19:13
 * update 2025/08/11 19:13
 *
 * @author Deng Haozhi
 * @see TransferValidateException
 * @since 1.0.0
 */
public class ReqTransferValidateException extends TransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1001");

    public ReqTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public ReqTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ReqTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ReqTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ReqTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ReqTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public ReqTransferValidateException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
