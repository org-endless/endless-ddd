package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisRemoveUnknownException
 * <p>
 * create 2024/09/29 16:04
 * <p>
 * update 2025/07/19 02:57
 *
 * @author Deng Haozhi
 * @see MybatisUnknownException
 * @since 1.0.0
 */
public class MybatisRemoveUnknownException extends MybatisUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT9002");

    public MybatisRemoveUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisRemoveUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisRemoveUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisRemoveUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisRemoveUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisRemoveUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
