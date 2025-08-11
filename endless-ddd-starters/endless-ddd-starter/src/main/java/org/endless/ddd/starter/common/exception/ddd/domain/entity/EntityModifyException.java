package org.endless.ddd.starter.common.exception.ddd.domain.entity;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * EntityModifyException
 * <p>
 * create 2025/08/10 08:34
 * <p>
 * update 2025/08/10 08:35
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityModifyException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEN0102");

    public EntityModifyException() {
        super(ERROR_CODE);
    }

    public EntityModifyException(String message) {
        super(ERROR_CODE, message);
    }

    public EntityModifyException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EntityModifyException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
