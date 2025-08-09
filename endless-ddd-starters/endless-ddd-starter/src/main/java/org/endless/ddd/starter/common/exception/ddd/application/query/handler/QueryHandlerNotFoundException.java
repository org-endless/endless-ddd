package org.endless.ddd.starter.common.exception.ddd.application.query.handler;

import org.endless.ddd.starter.common.exception.common.NotFoundException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * QueryHandlerNotFoundException
 * <p>
 * create 2024/11/26 22:03
 * <p>
 * update 2024/12/31 23:33
 *
 * @author Deng Haozhi
 * @see QueryHandlerException
 * @since 1.0.0
 */
public class QueryHandlerNotFoundException extends NotFoundException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DQR0001;

    public QueryHandlerNotFoundException() {
        super(ERROR_CODE);
    }

    public QueryHandlerNotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryHandlerNotFoundException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryHandlerNotFoundException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
