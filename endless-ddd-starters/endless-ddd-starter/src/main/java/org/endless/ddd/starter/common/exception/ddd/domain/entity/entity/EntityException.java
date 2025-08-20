package org.endless.ddd.starter.common.exception.ddd.domain.entity.entity;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * EntityException
 * <p>
 * create 2024/09/29 11:29
 * <p>
 * update 2025/08/10 08:31
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class EntityException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEN0000");

    public EntityException() {
        super(null, ERROR_CODE, null, null);
    }

    public EntityException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EntityException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EntityException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EntityException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EntityException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public EntityException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
