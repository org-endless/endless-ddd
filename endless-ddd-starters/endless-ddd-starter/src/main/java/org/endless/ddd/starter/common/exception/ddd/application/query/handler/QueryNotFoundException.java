package org.endless.ddd.starter.common.exception.ddd.application.query.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.NotFoundException;

/**
 * QueryNotFoundException
 * <p>
 * create 2024/11/26 22:03
 * <p>
 * update 2024/12/31 23:33
 *
 * @author Deng Haozhi
 * @see NotFoundException
 * @since 1.0.0
 */
public class QueryNotFoundException extends NotFoundException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DQR0010");

    public QueryNotFoundException() {
        super(null, ERROR_CODE, null, null);
    }

    public QueryNotFoundException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public QueryNotFoundException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public QueryNotFoundException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public QueryNotFoundException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public QueryNotFoundException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public QueryNotFoundException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
