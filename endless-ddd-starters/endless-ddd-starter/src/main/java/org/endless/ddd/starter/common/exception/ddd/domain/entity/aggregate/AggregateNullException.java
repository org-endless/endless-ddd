package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateNullException
 * <p>
 * create 2025/08/07 23:57
 * <p>
 * update 2025/08/07 23:57
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateNullException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0001");

    public AggregateNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
