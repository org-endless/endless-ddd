package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.ReqTransferValidateException;

/**
 * DrivenReqTransferValidateException
 * <p>
 * create 2025/01/09 17:55
 * <p>
 * update 2025/08/11 20:39
 *
 * @author Deng Haozhi
 * @see ReqTransferValidateException
 * @since 1.0.0
 */
public class DrivenReqTransferValidateException extends ReqTransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1301");

    public DrivenReqTransferValidateException() {
        super(ERROR_CODE);
    }

    public DrivenReqTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public DrivenReqTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DrivenReqTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
