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
        super(ERROR_CODE);
    }

    public ReqTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public ReqTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ReqTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public ReqTransferValidateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ReqTransferValidateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ReqTransferValidateException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public ReqTransferValidateException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
