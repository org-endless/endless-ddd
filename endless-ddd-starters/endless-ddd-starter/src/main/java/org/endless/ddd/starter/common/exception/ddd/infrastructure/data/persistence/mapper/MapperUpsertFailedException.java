package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * MapperUpsertUnknownException
 * <p>
 * create 2024/09/29 16:01
 * <p>
 * update 2025/07/19 02:58
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MapperUpsertFailedException extends MapperFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDP0140");

    public MapperUpsertFailedException() {
        super(ERROR_CODE);
    }

    public MapperUpsertFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperUpsertFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperUpsertFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
