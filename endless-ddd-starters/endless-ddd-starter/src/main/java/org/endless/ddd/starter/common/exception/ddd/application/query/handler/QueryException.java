package org.endless.ddd.starter.common.exception.ddd.application.query.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * QueryException
 * <p>
 * create 2024/09/29 11:17
 * <p>
 * update 2024/11/17 16:10
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class QueryException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DQR0000");

    public QueryException() {
        super(ERROR_CODE);
    }

    public QueryException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
