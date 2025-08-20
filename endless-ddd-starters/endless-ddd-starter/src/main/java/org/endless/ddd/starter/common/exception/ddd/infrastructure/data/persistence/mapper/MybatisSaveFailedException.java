package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisSaveFailedException
 * <p>
 * create 2024/09/12 12:12
 * <p>
 * update 2025/07/19 02:57
 *
 * @author Deng Haozhi
 * @see MybatisFailedException
 * @since 1.0.0
 */
public class MybatisSaveFailedException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT0001");

    public MybatisSaveFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisSaveFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisSaveFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisSaveFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisSaveFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisSaveFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
