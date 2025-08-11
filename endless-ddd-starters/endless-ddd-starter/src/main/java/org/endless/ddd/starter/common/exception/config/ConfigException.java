package org.endless.ddd.starter.common.exception.config;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0000");

    public ConfigException() {
        super(ERROR_CODE);
    }

    public ConfigException(String message) {
        super(ERROR_CODE, message);
    }

    public ConfigException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ConfigException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public ConfigException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ConfigException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ConfigException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public ConfigException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
