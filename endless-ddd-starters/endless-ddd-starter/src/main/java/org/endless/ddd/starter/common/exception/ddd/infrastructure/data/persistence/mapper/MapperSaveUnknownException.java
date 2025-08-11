package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * MapperSaveUnknownException
 * <p>
 * create 2024/09/12 12:12
 * <p>
 * update 2025/07/19 02:58
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MapperSaveUnknownException extends MapperUnknownException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DDP0111;

    public MapperSaveUnknownException() {
        super(ERROR_CODE);
    }

    public MapperSaveUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperSaveUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperSaveUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
