package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferNullException;

/**
 * QueryReqTransferNullException
 * <p>
 * create 2024/09/29 11:19
 * <p>
 * update 2025/01/09 18:01
 *
 * @author Deng Haozhi
 * @see RespTransferNullException
 * @since 1.0.0
 */
public class QueryRespTransferNullException extends RespTransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2200");

    public QueryRespTransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public QueryRespTransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public QueryRespTransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public QueryRespTransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public QueryRespTransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public QueryRespTransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
