package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisModifyUnknownException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2025/07/19 02:56
 *
 * @author Deng Haozhi
 * @see MybatisUnknownException
 * @since 1.0.0
 */
public class MybatisModifyUnknownException extends MybatisUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT9003");

    public MybatisModifyUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisModifyUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisModifyUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisModifyUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisModifyUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisModifyUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
