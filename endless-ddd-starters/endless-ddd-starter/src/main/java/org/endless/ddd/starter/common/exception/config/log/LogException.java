package org.endless.ddd.starter.common.exception.config.log;

import org.endless.ddd.starter.common.exception.config.ConfigException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * LogException
 * <p>
 * create 2024/11/13 09:19
 * <p>
 * update 2024/11/17 16:06
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class LogException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG0100;

    public LogException() {
        super(ERROR_CODE);
    }

    public LogException(String message) {
        super(ERROR_CODE, message);
    }

    public LogException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public LogException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
