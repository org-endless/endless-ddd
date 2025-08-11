package org.endless.ddd.starter.common.exception.ddd.application.query.handler;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * QueryHandlerException
 * <p>
 * create 2024/09/29 11:17
 * <p>
 * update 2024/11/17 16:10
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class QueryHandlerException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DQR0000;

    public QueryHandlerException() {
        super(ERROR_CODE);
    }

    public QueryHandlerException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryHandlerException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryHandlerException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
