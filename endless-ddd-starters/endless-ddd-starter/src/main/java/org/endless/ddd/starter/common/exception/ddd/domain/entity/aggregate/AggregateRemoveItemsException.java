package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * AggregateRemoveItemsException
 * <p>
 * create 2025/08/12 00:17
 * <p>
 * update 2025/08/12 00:19
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateRemoveItemsException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0203;

    public AggregateRemoveItemsException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateRemoveItemsException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateRemoveItemsException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateRemoveItemsException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateRemoveItemsException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateRemoveItemsException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
