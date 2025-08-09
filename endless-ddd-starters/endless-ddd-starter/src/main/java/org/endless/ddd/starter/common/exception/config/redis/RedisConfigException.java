package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.config.ConfigException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * RedisConfigException
 * <p>
 * create 2025/07/09 18:20
 * <p>
 * update 2025/07/09 18:20
 * update 2025/07/09 18:20
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RedisConfigException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG0400;

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
