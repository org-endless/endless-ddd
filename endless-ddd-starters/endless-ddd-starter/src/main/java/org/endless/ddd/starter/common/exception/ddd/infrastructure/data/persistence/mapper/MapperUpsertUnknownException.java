package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * MapperUpsertUnknownException
 * <p>
 * create 2024/09/29 16:01
 * <p>
 * update 2025/07/19 02:58
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class MapperUpsertUnknownException extends UnknownException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DDP0141;

    public MapperUpsertUnknownException() {
        super(ERROR_CODE);
    }

    public MapperUpsertUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperUpsertUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperUpsertUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
