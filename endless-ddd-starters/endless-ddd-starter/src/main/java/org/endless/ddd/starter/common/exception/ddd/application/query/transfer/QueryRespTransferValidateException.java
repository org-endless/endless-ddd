package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferValidateException;

/**
 * QueryRespTransferValidateException
 * <p>
 * create 2025/08/11 19:34
 * <p>
 * update 2025/08/11 19:37
 *
 * @author Deng Haozhi
 * @see RespTransferValidateException
 * @since 1.0.0
 */
public class QueryRespTransferValidateException extends RespTransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2201");

    public QueryRespTransferValidateException() {
        super(ERROR_CODE);
    }

    public QueryRespTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryRespTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryRespTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
