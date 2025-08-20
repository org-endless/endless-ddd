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
        super(null, ERROR_CODE, null, null);
    }

    public QueryException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public QueryException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public QueryException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public QueryException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public QueryException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public QueryException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
