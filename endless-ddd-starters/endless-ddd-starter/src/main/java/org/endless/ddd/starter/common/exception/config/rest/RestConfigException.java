package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.config.ConfigException;

/**
 * RestConfigException
 * <p>
 * create 2025/08/11 20:17
 * <p>
 * update 2025/08/11 20:17
 *
 * @author Deng Haozhi
 * @see ConfigException
 * @since 1.0.0
 */
public class RestConfigException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEN0100");

    public RestConfigException() {
        super(ERROR_CODE);
    }

    public RestConfigException(String message) {
        super(ERROR_CODE, message);
    }

    public RestConfigException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RestConfigException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
