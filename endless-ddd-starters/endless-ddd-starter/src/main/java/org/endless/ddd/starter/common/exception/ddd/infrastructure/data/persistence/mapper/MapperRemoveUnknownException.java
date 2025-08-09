package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * MapperRemoveUnknownException
 * <p>
 * create 2024/09/29 16:04
 * <p>
 * update 2025/07/19 02:57
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MapperRemoveUnknownException extends MapperUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDP0121;

    public MapperRemoveUnknownException() {
        super(ERROR_CODE);
    }

    public MapperRemoveUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperRemoveUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperRemoveUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
