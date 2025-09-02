package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * MybatisReturnNullException
 * <p>
 * create 2025/08/21 00:58
 * <p>
 * update 2025/08/21 00:58
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class MybatisReturnNullException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MBT8100;

    public MybatisReturnNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisReturnNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisReturnNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisReturnNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisReturnNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisReturnNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
