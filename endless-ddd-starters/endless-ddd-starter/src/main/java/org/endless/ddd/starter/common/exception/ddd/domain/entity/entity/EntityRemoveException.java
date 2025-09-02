package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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
        super(null, ERROR_CODE, null, null);
    }

    public EntityRemoveException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityRemoveException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityRemoveException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityRemoveException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityRemoveException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
