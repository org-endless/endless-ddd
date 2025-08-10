package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.ddd.domain.entity.EntityException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * AggregateException
 * <p>
 * create 2024/09/29 11:30
 * <p>
 * update 2024/11/17 16:12
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class AggregateException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0000;

    public AggregateException() {
        super(ERROR_CODE);
    }

    public AggregateException(String message) {
        super(ERROR_CODE, message);
    }

    public AggregateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AggregateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public AggregateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AggregateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public AggregateException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public AggregateException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
