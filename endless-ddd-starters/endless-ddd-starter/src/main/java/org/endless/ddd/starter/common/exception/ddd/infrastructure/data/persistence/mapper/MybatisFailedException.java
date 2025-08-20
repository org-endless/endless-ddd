package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MybatisFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/01 16:52
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MybatisFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT0000");

    public MybatisFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public MybatisFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
