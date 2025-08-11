package org.endless.ddd.starter.common.exception.ddd.domain.entity;

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
        super(ERROR_CODE);
    }

    public EntityException(String message) {
        super(ERROR_CODE, message);
    }

    public EntityException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EntityException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public EntityException(ErrorCode errorCode) {
        super(errorCode);
    }

    public EntityException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public EntityException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public EntityException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
