package org.endless.ddd.starter.common.exception.config;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * ConfigException
 * <p>
 * create 2025/08/09 04:45
 * <p>
 * update 2025/08/11 18:51
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class ConfigException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.CFG0000;

    public ConfigException() {
        super(null, ERROR_CODE, null, null);
    }

    public ConfigException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ConfigException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ConfigException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ConfigException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ConfigException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public ConfigException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
