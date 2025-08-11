package org.endless.ddd.starter.common.exception.config.redis;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * RedisStreamAddException
 * <p>
 * create 2025/07/10 03:58
 * <p>
 * update 2025/07/10 03:58
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RedisStreamAddException extends RedisConfigException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.CFG0421;

    public RedisStreamAddException() {
        super(ERROR_CODE);
    }

    public RedisStreamAddException(String message) {
        super(ERROR_CODE, message);
    }

    public RedisStreamAddException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RedisStreamAddException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
