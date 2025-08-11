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
        super(ERROR_CODE);
    }

    public RedisConfigException(String message) {
        super(ERROR_CODE, message);
    }

    public RedisConfigException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RedisConfigException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RedisConfigException(ErrorCode errorCode) {
        super(errorCode);
    }

    public RedisConfigException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public RedisConfigException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RedisConfigException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
