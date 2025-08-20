package org.endless.ddd.starter.common.exception.config.utils.id;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.config.ConfigException;

/**
 * IdException
 * <p>
 * create 2024/12/25 11:17
 * <p>
 * update 2024/12/25 11:17
 *
 * @author Deng Haozhi
 * @see ConfigException
 * @since 1.0.0
 */
public class IdGeneratorException extends ConfigException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("CFG8000");

    public IdGeneratorException() {
        super(null, ERROR_CODE, null, null);
    }

    public IdGeneratorException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public IdGeneratorException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public IdGeneratorException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public IdGeneratorException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public IdGeneratorException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public IdGeneratorException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
