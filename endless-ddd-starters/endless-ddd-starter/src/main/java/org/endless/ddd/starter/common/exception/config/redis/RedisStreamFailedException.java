package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * RedisStreamFailedException
 * <p>
 * create 2025/08/20 22:58
 * <p>
 * update 2025/08/20 22:58
 *
 * @author Deng Haozhi
 * @see RedisFailedException
 * @since 1.0.0
 */
public class RedisStreamFailedException extends RedisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.RDS0100;

    public RedisStreamFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisStreamFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisStreamFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisStreamFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisStreamFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisStreamFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RedisStreamFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
