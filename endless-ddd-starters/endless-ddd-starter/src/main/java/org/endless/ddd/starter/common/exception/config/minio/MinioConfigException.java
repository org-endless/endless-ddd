package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.config.ConfigException;

/**
 * MinioConfigException
 * <p>
 * create 2024/11/07 12:07
 * <p>
 * update 2025/08/09 05:00
 *
 * @author Deng Haozhi
 * @see ConfigException
 * @since 1.0.0
 */
public class MinioConfigException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0300");

    public MinioConfigException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioConfigException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioConfigException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioConfigException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioConfigException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioConfigException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
