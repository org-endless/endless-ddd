package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0001;

    public AggregateNullException() {
        super(ERROR_CODE);
    }

    public AggregateNullException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
