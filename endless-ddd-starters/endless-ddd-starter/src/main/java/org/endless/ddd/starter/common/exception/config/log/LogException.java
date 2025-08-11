package org.endless.ddd.starter.common.exception.config.log;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.config.ConfigException;

/**
 * LogException
 * <p>
 * create 2024/11/13 09:19
 * <p>
 * update 2025/08/11 18:50
 *
 * @author Deng Haozhi
 * @see ConfigException
 * @since 1.0.0
 */
public class LogException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0100");

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
