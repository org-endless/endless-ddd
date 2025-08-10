package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * AggregateModifyException
 * <p>
 * create 2024/11/19 21:28
 * <p>
 * update 2024/11/19 21:29
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateModifyException extends AggregateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0102;

    public AggregateModifyException() {
        super(ERROR_CODE);
    }

    public AggregateModifyException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateModifyException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateModifyException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
