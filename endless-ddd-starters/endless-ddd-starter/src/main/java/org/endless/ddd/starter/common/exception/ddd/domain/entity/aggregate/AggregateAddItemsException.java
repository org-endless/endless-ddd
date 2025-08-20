package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateAddItemsException
 * <p>
 * create 2025/08/12 00:16
 * <p>
 * update 2025/08/12 00:19
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateAddItemsException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0201");

    public AggregateAddItemsException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateAddItemsException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateAddItemsException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateAddItemsException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateAddItemsException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateAddItemsException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
