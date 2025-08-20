package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisParameterNullException
 * <p>
 * create 2025/08/21 00:58
 * <p>
 * update 2025/08/21 00:58
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class MybatisParameterNullException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT8000");

    public MybatisParameterNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisParameterNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisParameterNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisParameterNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisParameterNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisParameterNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
