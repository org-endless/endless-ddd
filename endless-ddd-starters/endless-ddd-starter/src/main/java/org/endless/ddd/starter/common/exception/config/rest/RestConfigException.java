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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0200");

    public RestConfigException() {
        super(null, ERROR_CODE, null, null);
    }

    public RestConfigException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RestConfigException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RestConfigException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RestConfigException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RestConfigException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public RestConfigException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
