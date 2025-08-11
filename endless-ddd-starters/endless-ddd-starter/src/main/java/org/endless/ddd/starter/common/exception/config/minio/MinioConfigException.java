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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG0200");

    public MinioConfigException() {
        super(ERROR_CODE);
    }

    public MinioConfigException(String message) {
        super(ERROR_CODE, message);
    }

    public MinioConfigException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MinioConfigException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
