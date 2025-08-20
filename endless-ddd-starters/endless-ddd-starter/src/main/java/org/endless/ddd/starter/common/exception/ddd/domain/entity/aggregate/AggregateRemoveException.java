package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateRemoveException
 * <p>
 * create 2024/10/12 10:11
 * <p>
 * update 2024/11/17 16:12
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateRemoveException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0101");

    public AggregateRemoveException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateRemoveException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateRemoveException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateRemoveException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateRemoveException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateRemoveException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
