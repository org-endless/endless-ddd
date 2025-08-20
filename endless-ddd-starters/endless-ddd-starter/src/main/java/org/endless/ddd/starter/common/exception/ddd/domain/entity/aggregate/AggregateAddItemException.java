package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateAddItemException
 * <p>
 * create 2025/08/12 00:16
 * <p>
 * update 2025/08/12 00:19
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateAddItemException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0200");

    public AggregateAddItemException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateAddItemException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateAddItemException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateAddItemException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateAddItemException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateAddItemException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
