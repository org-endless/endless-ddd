package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * EntityReturnNullException
 * <p>
 * create 2025/08/21 01:18
 * <p>
 * update 2025/08/21 01:20
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityReturnNullException extends EntityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEN8100");

    public EntityReturnNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public EntityReturnNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityReturnNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityReturnNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityReturnNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityReturnNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
