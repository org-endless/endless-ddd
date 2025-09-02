package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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
        super(null, ERROR_CODE, null, null);
    }

    public EntityValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
