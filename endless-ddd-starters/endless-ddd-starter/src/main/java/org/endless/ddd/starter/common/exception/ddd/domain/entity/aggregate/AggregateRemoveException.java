package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * AggregateRemoveException
 * <p>
 * create 2024/10/12 10:11
 * <p>
 * update 2024/11/17 16:12
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 1.0.0
 */
public class AggregateRemoveException extends AggregateException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DAG0101;

    public AggregateRemoveException() {
        super(ERROR_CODE);
    }

    public AggregateRemoveException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateRemoveException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateRemoveException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
