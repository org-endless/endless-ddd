package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RedisSerializerException
 * <p>
 * create 2025/07/09 18:25
 * <p>
 * update 2025/07/09 18:25
 *
 * @author Deng Haozhi
 * @see RedisConfigException
 * @since 1.0.0
 */
public class RedisSerializerException extends RedisConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0410");

    public RedisSerializerException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisSerializerException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisSerializerException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisSerializerException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisSerializerException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisSerializerException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
