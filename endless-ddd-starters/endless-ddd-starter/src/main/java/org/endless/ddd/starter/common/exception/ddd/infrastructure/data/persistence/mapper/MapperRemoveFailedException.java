package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MapperRemoveFieldException
 * <p>
 * create 2024/11/06 09:37
 * <p>
 * update 2025/07/19 02:57
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MapperRemoveFailedException extends MapperFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDP0120");

    public MapperRemoveFailedException() {
        super(ERROR_CODE);
    }

    public MapperRemoveFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperRemoveFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperRemoveFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
