package org.endless.ddd.starter.common.exception.ddd.domain.entity;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * AggregateValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/07 23:57
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class AggregateValidateException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0001;

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
