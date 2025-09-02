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
 * @see MybatisUnknownException
 * @since 1.0.0
 */
public class MybatisUpsertUnknownException extends MybatisUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MBT9004;

    public MybatisUpsertUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisUpsertUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisUpsertUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisUpsertUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisUpsertUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisUpsertUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
