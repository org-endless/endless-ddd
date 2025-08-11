package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * AggregateRemoveItemException
 * <p>
 * create 2025/08/12 00:16
 * <p>
 * update 2025/08/12 00:19
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateRemoveItemException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DAG0202");

    public AggregateRemoveItemException() {
        super(ERROR_CODE);
    }

    public AggregateRemoveItemException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateRemoveItemException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateRemoveItemException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
