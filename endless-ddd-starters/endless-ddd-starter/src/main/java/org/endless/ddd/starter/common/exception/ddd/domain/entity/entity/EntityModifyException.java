package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

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
        super(null, ERROR_CODE, null, null);
    }

    public EntityModifyException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityModifyException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityModifyException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityModifyException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityModifyException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
