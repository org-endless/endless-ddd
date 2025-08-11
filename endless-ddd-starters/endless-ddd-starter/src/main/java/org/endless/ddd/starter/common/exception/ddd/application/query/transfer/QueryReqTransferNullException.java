package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * QueryReqTransferNullException
 * <p>
 * create 2024/09/29 11:19
 * <p>
 * update 2025/01/09 18:01
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class QueryReqTransferNullException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DTS0200;

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
