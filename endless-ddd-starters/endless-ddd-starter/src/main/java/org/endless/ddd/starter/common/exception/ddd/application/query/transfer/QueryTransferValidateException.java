package org.endless.ddd.starter.common.exception.ddd.application.query.transfer;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * QueryTransferValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/11/16 23:37
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class QueryTransferValidateException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DTO0201;

    public QueryTransferValidateException() {
        super(ERROR_CODE);
    }

    public QueryTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
