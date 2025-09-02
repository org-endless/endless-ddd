package org.endless.ddd.starter.common.exception.config.utils.id;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * MapperException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see IdGeneratorException
 * @since 1.0.0
 */
public class SnowflakeIdGeneratorException extends IdGeneratorException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG8001;

    public SnowflakeIdGeneratorException() {
        super(null, ERROR_CODE, null, null);
    }

    public SnowflakeIdGeneratorException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SnowflakeIdGeneratorException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SnowflakeIdGeneratorException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SnowflakeIdGeneratorException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SnowflakeIdGeneratorException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
