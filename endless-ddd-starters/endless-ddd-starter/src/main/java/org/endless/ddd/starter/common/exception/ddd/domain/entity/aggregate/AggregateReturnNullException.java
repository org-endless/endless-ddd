package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateReturnNullException
 * <p>
 * create 2025/08/12 00:14
 * <p>
 * update 2025/08/12 00:20
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateReturnNullException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0103");

    public AggregateReturnNullException() {
        super(ERROR_CODE);
    }

    public AggregateReturnNullException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateReturnNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateReturnNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
