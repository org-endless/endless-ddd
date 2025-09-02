package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO1301;

    public DrivenReqTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenReqTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenReqTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenReqTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenReqTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenReqTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }


}
