package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisReturnValidateException
 * <p>
 * create 2025/08/21 00:59
 * <p>
 * update 2025/08/21 00:59
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class MybatisReturnValidateException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT8101");

    public MybatisReturnValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisReturnValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisReturnValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisReturnValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisReturnValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisReturnValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
