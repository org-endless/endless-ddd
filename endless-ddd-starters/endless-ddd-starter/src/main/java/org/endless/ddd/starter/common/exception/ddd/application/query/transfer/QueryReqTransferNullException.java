package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.ReqTransferNullException;

/**
 * QueryReqTransferNullException
 * <p>
 * create 2024/09/29 11:19
 * <p>
 * update 2025/08/11 19:35
 *
 * @author Deng Haozhi
 * @see ReqTransferNullException
 * @since 1.0.0
 */
public class QueryReqTransferNullException extends ReqTransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO1200;

    public QueryReqTransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public QueryReqTransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public QueryReqTransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public QueryReqTransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public QueryReqTransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public QueryReqTransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
