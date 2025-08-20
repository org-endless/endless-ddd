package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisModifyFailedException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2025/07/19 02:56
 *
 * @author Deng Haozhi
 * @see MybatisFailedException
 * @since 1.0.0
 */
public class MybatisModifyFailedException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT0003");

    public MybatisModifyFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisModifyFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisModifyFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisModifyFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisModifyFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisModifyFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
