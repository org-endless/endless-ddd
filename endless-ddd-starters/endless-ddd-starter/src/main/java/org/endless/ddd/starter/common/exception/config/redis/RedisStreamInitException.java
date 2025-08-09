package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * RedisStreamInitException
 * <p>
 * create 2025/07/10 04:59
 * <p>
 * update 2025/07/10 05:01
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RedisStreamInitException extends RedisConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG0420;

    public RedisStreamInitException() {
        super(ERROR_CODE);
    }

    public RedisStreamInitException(String message) {
        super(ERROR_CODE, message);
    }

    public RedisStreamInitException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RedisStreamInitException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
