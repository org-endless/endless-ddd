package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * MapperFindException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2025/07/01 16:52
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MapperFindException extends MapperFailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DDP0150;

    public MapperFindException() {
        super(ERROR_CODE);
    }

    public MapperFindException(String message) {
        super(ERROR_CODE, message);
    }

    public MapperFindException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public MapperFindException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
