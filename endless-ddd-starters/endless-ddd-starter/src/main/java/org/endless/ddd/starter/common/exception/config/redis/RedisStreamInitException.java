package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RedisStreamInitException
 * <p>
 * create 2025/07/10 04:59
 * <p>
 * update 2025/07/10 05:01
 *
 * @author Deng Haozhi
 * @see RedisStreamConfigException
 * @since 1.0.0
 */
public class RedisStreamInitException extends RedisStreamConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0421");

    public RedisStreamInitException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisStreamInitException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisStreamInitException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisStreamInitException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisStreamInitException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisStreamInitException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
