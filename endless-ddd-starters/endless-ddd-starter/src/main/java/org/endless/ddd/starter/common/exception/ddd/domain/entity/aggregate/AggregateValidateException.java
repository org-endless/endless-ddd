package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

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

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DAG0002;

    public AggregateValidateException() {
        super(ERROR_CODE);
    }

    public AggregateValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
