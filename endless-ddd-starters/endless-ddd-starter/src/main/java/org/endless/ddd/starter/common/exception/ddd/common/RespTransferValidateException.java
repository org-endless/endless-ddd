package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO2001;

    public RespTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public RespTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RespTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RespTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RespTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RespTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RespTransferValidateException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
