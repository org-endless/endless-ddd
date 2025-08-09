package org.endless.ddd.starter.common.exception.ddd.domain.entity;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * EntityNullException
 * <p>
 * create 2025/08/07 23:54
 * <p>
 * update 2025/08/07 23:56
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class EntityNullException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DEN0000;

    public EntityNullException() {
        super(ERROR_CODE);
    }

    public EntityNullException(String message) {
        super(ERROR_CODE, message);
    }

    public EntityNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EntityNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
