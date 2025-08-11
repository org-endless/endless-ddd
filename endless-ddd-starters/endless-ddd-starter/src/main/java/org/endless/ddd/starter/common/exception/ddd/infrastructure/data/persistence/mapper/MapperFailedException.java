package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MapperFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/01 16:52
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MapperFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDP0100");

    public MapperFailedException() {
        super(ERROR_CODE);
    }

    public MapperFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public MapperFailedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MapperFailedException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MapperFailedException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public MapperFailedException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
