package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG8001;

    public AggregateParameterValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateParameterValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateParameterValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateParameterValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateParameterValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateParameterValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
