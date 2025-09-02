package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * MybatisUpsertUnknownException
 * <p>
 * create 2024/09/29 16:01
 * <p>
 * update 2025/07/19 02:58
 *
 * @author Deng Haozhi
 * @see MybatisFailedException
 * @since 1.0.0
 */
public class MybatisUpsertFailedException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MBT0004;

    public MybatisUpsertFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisUpsertFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisUpsertFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisUpsertFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisUpsertFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisUpsertFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
