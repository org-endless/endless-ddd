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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG8000");

    public AggregateParameterNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateParameterNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateParameterNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateParameterNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateParameterNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateParameterNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
