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
        super(ERROR_CODE);
    }

    public QueryReqTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryReqTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryReqTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
