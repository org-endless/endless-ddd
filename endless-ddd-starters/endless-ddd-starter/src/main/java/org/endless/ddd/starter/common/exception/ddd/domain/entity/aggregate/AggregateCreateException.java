package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0110");

    public AggregateCreateException() {
        super(ERROR_CODE);
    }

    public AggregateCreateException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateCreateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateCreateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
