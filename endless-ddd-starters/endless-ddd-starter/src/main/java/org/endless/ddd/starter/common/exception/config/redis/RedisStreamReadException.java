package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RedisStreamReadException
 * <p>
 * create 2025/08/20 22:57
 * <p>
 * update 2025/08/20 23:00
 *
 * @author Deng Haozhi
 * @see RedisStreamFailedException
 * @since 1.0.0
 */
public class RedisStreamReadException extends RedisStreamFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RDS0102");

    public RedisStreamReadException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisStreamReadException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisStreamReadException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisStreamReadException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisStreamReadException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisStreamReadException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
