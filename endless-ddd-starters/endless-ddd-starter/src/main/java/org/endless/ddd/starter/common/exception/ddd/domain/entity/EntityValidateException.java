package org.endless.ddd.starter.common.exception.ddd.domain.entity;

import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * EntityValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/07 23:56
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityValidateException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DEN0002;

    public EntityValidateException() {
        super(ERROR_CODE);
    }

    public EntityValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public EntityValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EntityValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
