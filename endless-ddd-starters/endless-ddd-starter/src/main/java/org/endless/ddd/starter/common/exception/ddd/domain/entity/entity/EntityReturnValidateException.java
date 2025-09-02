package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * EntityReturnValidateException
 * <p>
 * create 2025/08/21 01:18
 * <p>
 * update 2025/08/21 01:20
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityReturnValidateException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DEN8101;

    public EntityReturnValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public EntityReturnValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityReturnValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityReturnValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityReturnValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityReturnValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
