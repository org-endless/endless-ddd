package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1200");

    public QueryReqTransferNullException() {
        super(ERROR_CODE);
    }

    public QueryReqTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryReqTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryReqTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
