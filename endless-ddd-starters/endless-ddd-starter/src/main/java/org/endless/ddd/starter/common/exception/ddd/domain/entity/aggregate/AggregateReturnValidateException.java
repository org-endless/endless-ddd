package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateReturnValidateException
 * <p>
 * create 2025/08/12 00:14
 * <p>
 * update 2025/08/12 00:20
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateReturnValidateException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0104");

    public AggregateReturnValidateException() {
        super(ERROR_CODE);
    }

    public AggregateReturnValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateReturnValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateReturnValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
