package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * MapperUnknownException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/19 02:58
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MapperUnknownException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDP0101;

    public MapperUnknownException() {
        super(ERROR_CODE);
    }

    public MapperUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public MapperUnknownException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MapperUnknownException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MapperUnknownException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public MapperUnknownException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
