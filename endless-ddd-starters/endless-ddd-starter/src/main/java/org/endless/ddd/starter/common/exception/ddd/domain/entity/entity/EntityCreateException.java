package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * EntityCreateException
 * <p>
 * create 2025/08/10 08:28
 * <p>
 * update 2025/08/10 08:29
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityCreateException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEN0100");

    public EntityCreateException() {
        super(null, ERROR_CODE, null, null);
    }

    public EntityCreateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityCreateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityCreateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityCreateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityCreateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
