package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * AggregateCreateException
 * <p>
 * create 2024/11/19 16:37
 * <p>
 * update 2024/11/19 16:37
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateCreateException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0100;

    public AggregateCreateException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateCreateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateCreateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateCreateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateCreateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateCreateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
