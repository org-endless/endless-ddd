package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisParameterValidateException
 * <p>
 * create 2025/08/21 00:58
 * <p>
 * update 2025/08/21 00:58
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class MybatisParameterValidateException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT8001");

    public MybatisParameterValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisParameterValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisParameterValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisParameterValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisParameterValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisParameterValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
