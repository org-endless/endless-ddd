package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * RedisStreamAddException
 * <p>
 * create 2025/07/10 03:58
 * <p>
 * update 2025/07/10 03:58
 *
 * @author Deng Haozhi
 * @see RedisStreamFailedException
 * @since 1.0.0
 */
public class RedisStreamAddException extends RedisStreamFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.RDS0101;

    public RedisStreamAddException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisStreamAddException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisStreamAddException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisStreamAddException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisStreamAddException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisStreamAddException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
