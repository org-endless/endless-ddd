package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.NotFoundException;

/**
 * MybatisNotFoundException
 * <p>
 * create 2025/08/21 00:48
 * <p>
 * update 2025/08/21 00:49
 *
 * @author Deng Haozhi
 * @see NotFoundException
 * @since 1.0.0
 */
public class MybatisNotFoundException extends NotFoundException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT1001");

    public MybatisNotFoundException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisNotFoundException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisNotFoundException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisNotFoundException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisNotFoundException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisNotFoundException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
