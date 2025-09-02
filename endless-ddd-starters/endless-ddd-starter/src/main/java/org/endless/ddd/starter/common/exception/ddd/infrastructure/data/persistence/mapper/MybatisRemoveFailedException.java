package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * MybatisRemoveFieldException
 * <p>
 * create 2024/11/06 09:37
 * <p>
 * update 2025/07/19 02:57
 *
 * @author Deng Haozhi
 * @see MybatisFailedException
 * @since 1.0.0
 */
public class MybatisRemoveFailedException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MBT0002;

    public MybatisRemoveFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisRemoveFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisRemoveFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisRemoveFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisRemoveFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisRemoveFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
