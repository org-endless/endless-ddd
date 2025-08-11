package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MapperBulkException
 * <p>
 * create 2025/07/01 16:34
 * <p>
 * update 2025/07/01 16:52
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MapperBulkException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDP0160");

    public MapperBulkException() {
        super(ERROR_CODE);
    }

    public MapperBulkException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperBulkException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperBulkException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
