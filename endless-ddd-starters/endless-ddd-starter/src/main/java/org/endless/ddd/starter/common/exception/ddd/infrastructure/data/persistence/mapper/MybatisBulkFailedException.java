package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisBulkException
 * <p>
 * create 2025/07/01 16:34
 * <p>
 * update 2025/08/21 00:52
 *
 * @author Deng Haozhi
 * @see MybatisFailedException
 * @since 1.0.0
 */
public class MybatisBulkFailedException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT0100");

    public MybatisBulkFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisBulkFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisBulkFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisBulkFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisBulkFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisBulkFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public MybatisBulkFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
