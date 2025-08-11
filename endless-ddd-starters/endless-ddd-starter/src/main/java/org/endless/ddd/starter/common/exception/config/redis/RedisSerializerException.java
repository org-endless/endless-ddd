package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RedisSerializerException
 * <p>
 * create 2025/07/09 18:25
 * <p>
 * update 2025/07/09 18:25
 * update 2025/07/09 18:25
 *
 * @author Deng Haozhi
 * @see RedisConfigException
 * @since 1.0.0
 */
public class RedisSerializerException extends RedisConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0410");

    public RedisSerializerException() {
        super(ERROR_CODE);
    }

    public RedisSerializerException(String message) {
        super(ERROR_CODE, message);
    }

    public RedisSerializerException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RedisSerializerException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
