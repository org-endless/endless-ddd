package org.endless.ddd.starter.common.exception.config;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * ConfigException
 * <p>
 * create 2025/08/09 04:45
 * <p>
 * update 2025/08/09 04:45
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class ConfigException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.CFG0000;

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

    public ConfigException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public ConfigException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public ConfigException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public ConfigException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
