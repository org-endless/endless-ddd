package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * RedisStreamConfigException
 * <p>
 * create 2025/08/20 22:54
 * <p>
 * update 2025/08/20 23:00
 *
 * @author Deng Haozhi
 * @see RedisConfigException
 * @since 1.0.0
 */
public class RedisStreamConfigException extends RedisConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG0420;

    public RedisStreamConfigException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisStreamConfigException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisStreamConfigException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisStreamConfigException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisStreamConfigException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisStreamConfigException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RedisStreamConfigException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
