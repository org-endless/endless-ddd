package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * RedisFailedException
 * <p>
 * create 2025/08/20 22:46
 * <p>
 * update 2025/08/20 22:46
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RedisFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("RDS0000");

    public RedisFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RedisFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
