package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.ReqTransferValidateException;

/**
 * QueryReqTransferValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/11/16 23:37
 *
 * @author Deng Haozhi
 * @see ReqTransferValidateException
 * @since 1.0.0
 */
public class QueryReqTransferValidateException extends ReqTransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1201");

    public QueryReqTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public QueryReqTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public QueryReqTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public QueryReqTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public QueryReqTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public QueryReqTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
