package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateModifyException
 * <p>
 * create 2024/11/19 21:28
 * <p>
 * update 2024/11/19 21:29
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateModifyException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0102");

    public AggregateModifyException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateModifyException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateModifyException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateModifyException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateModifyException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateModifyException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
