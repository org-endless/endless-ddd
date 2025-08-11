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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DQR0001");

    public QueryNotFoundException() {
        super(ERROR_CODE);
    }

    public QueryNotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public QueryNotFoundException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public QueryNotFoundException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
