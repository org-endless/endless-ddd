package org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate;

import org.endless.ddd.starter.common.exception.ddd.domain.entity.EntityException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

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

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DAG0000;

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

    public AggregateException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public AggregateException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public AggregateException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public AggregateException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
