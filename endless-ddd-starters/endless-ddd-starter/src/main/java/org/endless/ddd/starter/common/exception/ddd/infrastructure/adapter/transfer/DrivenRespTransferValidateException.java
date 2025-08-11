package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2301");

    public DrivenRespTransferValidateException() {
        super(ERROR_CODE);
    }

    public DrivenRespTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public DrivenRespTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DrivenRespTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
