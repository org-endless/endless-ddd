package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * MybatisUnknownException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/19 02:58
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MybatisUnknownException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT9000");

    public MybatisUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public MybatisUnknownException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
