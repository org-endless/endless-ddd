package org.endless.ddd.starter.common.exception.utils.id;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MapperException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class SnowflakeIdException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0001");

    public SnowflakeIdException() {
        super(ERROR_CODE);
    }

    public SnowflakeIdException(String message) {
        super(ERROR_CODE, message);
    }

    public SnowflakeIdException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public SnowflakeIdException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
