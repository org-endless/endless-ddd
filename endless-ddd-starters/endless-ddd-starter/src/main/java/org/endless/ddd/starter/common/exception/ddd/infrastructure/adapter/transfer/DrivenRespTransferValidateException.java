package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferValidateException;

/**
 * DrivenRespTransferValidateException
 * <p>
 * create 2025/08/11 20:37
 * <p>
 * update 2025/08/11 20:40
 *
 * @author Deng Haozhi
 * @see RespTransferValidateException
 * @since 1.0.0
 */
public class DrivenRespTransferValidateException extends RespTransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO2301;

    public DrivenRespTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenRespTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenRespTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenRespTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenRespTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenRespTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }


}
