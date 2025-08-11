package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.ReqTransferNullException;

/**
 * DrivenReqTransferNullException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/11 20:39
 *
 * @author Deng Haozhi
 * @see ReqTransferNullException
 * @since 1.0.0
 */
public class DrivenReqTransferNullException extends ReqTransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1300");

    public DrivenReqTransferNullException() {
        super(ERROR_CODE);
    }

    public DrivenReqTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public DrivenReqTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DrivenReqTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
