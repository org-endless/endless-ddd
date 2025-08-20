package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferNullException;

/**
 * DrivenReqTransferNullException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/11 20:39
 *
 * @author Deng Haozhi
 * @see RespTransferNullException
 * @since 1.0.0
 */
public class DrivenRespTransferNullException extends RespTransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2300");

    public DrivenRespTransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenRespTransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenRespTransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenRespTransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenRespTransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenRespTransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }


}
