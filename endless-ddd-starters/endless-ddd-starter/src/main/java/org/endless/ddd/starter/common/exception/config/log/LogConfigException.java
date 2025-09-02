package org.endless.ddd.starter.common.exception.config.log;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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
public class LogConfigException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG0100;

    public LogConfigException() {
        super(null, ERROR_CODE, null, null);
    }

    public LogConfigException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public LogConfigException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public LogConfigException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public LogConfigException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public LogConfigException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
