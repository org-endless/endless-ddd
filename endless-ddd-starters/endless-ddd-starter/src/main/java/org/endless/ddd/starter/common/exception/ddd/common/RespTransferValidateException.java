package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RespTransferValidateException
 * <p>
 * create 2025/08/11 19:14
 * <p>
 * update 2025/08/11 19:14
 * update 2025/08/11 19:14
 *
 * @author Deng Haozhi
 * @see TransferValidateException
 * @since 1.0.0
 */
public class RespTransferValidateException extends TransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2001");

    public RespTransferValidateException() {
        super(ERROR_CODE);
    }

    public RespTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public RespTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RespTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RespTransferValidateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public RespTransferValidateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public RespTransferValidateException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RespTransferValidateException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
