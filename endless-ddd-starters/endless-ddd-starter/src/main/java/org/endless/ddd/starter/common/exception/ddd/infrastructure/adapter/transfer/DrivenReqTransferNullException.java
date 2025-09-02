package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO1300;

    public DrivenReqTransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenReqTransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenReqTransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenReqTransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenReqTransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenReqTransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }


}
