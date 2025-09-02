package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * MybatisBulkUnknowException
 * <p>
 * create 2025/08/21 00:53
 * <p>
 * update 2025/08/21 00:53
 *
 * @author Deng Haozhi
 * @see MybatisUnknownException
 * @since 1.0.0
 */
public class MybatisBulkUnknowException extends MybatisUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MBT9100;

    public MybatisBulkUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisBulkUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisBulkUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisBulkUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisBulkUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisBulkUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public MybatisBulkUnknowException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
