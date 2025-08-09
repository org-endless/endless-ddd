package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * MapperModifyUnknownException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2025/07/19 02:56
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MapperModifyUnknownException extends MapperUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDP0131;

    public MapperModifyUnknownException() {
        super(ERROR_CODE);
    }

    public MapperModifyUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperModifyUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperModifyUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
