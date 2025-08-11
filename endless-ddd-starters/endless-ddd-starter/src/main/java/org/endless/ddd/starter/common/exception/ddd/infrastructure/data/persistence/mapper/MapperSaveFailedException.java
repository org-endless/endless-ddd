package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MapperSaveFailedException
 * <p>
 * create 2024/09/12 12:12
 * <p>
 * update 2025/07/19 02:57
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MapperSaveFailedException extends MapperFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDP0110");

    public MapperSaveFailedException() {
        super(ERROR_CODE);
    }

    public MapperSaveFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperSaveFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperSaveFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
