package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * EntityParameterNullException
 * <p>
 * create 2025/08/21 01:18
 * <p>
 * update 2025/08/21 01:19
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityParameterNullException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DEN8000;

    public EntityParameterNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public EntityParameterNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityParameterNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityParameterNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityParameterNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityParameterNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
