package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateParameterValidateException
 * <p>
 * create 2025/08/12 00:14
 * <p>
 * update 2025/08/12 00:20
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateParameterValidateException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0101");

    public AggregateParameterValidateException() {
        super(ERROR_CODE);
    }

    public AggregateParameterValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateParameterValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateParameterValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
