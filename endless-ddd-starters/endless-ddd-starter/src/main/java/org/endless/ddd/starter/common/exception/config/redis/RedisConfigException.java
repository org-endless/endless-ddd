package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.config.ConfigException;

/**
 * RedisConfigException
 * <p>
 * create 2025/07/09 18:20
 * <p>
 * update 2025/07/09 18:20
 * update 2025/07/09 18:20
 *
 * @author Deng Haozhi
 * @see ConfigException
 * @since 1.0.0
 */
public class RedisConfigException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0400");

    public RedisConfigException() {
        super(null, ERROR_CODE, null, null);
    }

    public RedisConfigException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RedisConfigException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RedisConfigException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RedisConfigException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RedisConfigException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RedisConfigException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
