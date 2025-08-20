package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/07 23:57
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateValidateException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0002");

    public AggregateValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
