package org.endless.ddd.starter.common.exception.ddd.domain.entity;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * EntityRemoveException
 * <p>
 * create 2024/10/12 09:36
 * <p>
 * update 2024/11/17 16:13
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityRemoveException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DEN0101;

    public EntityRemoveException() {
        super(ERROR_CODE);
    }

    public EntityRemoveException(String message) {
        super(ERROR_CODE, message);
    }

    public EntityRemoveException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EntityRemoveException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
