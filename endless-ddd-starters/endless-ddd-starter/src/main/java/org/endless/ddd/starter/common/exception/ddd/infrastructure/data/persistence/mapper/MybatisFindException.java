package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisFindException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2025/07/01 16:52
 *
 * @author Deng Haozhi
 * @see MybatisFailedException
 * @since 1.0.0
 */
public class MybatisFindException extends MybatisFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MBT1000");

    public MybatisFindException() {
        super(null, ERROR_CODE, null, null);
    }

    public MybatisFindException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MybatisFindException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MybatisFindException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MybatisFindException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MybatisFindException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
