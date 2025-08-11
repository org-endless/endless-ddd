package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateParameterNullException
 * <p>
 * create 2025/08/12 00:13
 * <p>
 * update 2025/08/12 00:19
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateParameterNullException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0100");

    public AggregateParameterNullException() {
        super(ERROR_CODE);
    }

    public AggregateParameterNullException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateParameterNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateParameterNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
