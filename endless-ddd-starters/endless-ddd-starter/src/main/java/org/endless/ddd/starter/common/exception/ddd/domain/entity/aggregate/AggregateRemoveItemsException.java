package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0203");

    public AggregateRemoveItemsException() {
        super(ERROR_CODE);
    }

    public AggregateRemoveItemsException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateRemoveItemsException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateRemoveItemsException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
