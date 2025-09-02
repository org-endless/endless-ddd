package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * AggregateException
 * <p>
 * create 2024/09/29 11:30
 * <p>
 * update 2024/11/17 16:12
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class AggregateException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DAG0000;

    public AggregateException() {
        super(null, ERROR_CODE, null, null);
    }

    public AggregateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AggregateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AggregateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AggregateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AggregateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public AggregateException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
