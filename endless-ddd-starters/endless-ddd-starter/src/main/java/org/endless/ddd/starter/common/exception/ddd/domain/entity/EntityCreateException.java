package org.endless.ddd.starter.common.exception.ddd.domain.entity;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * EntityCreateException
 * <p>
 * create 2025/08/10 08:28
 * <p>
 * update 2025/08/10 08:29
 *
 * @author Deng Haozhi
 * @see EntityException
 * @since 1.0.0
 */
public class EntityCreateException extends EntityException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DEN0100;

    public EntityCreateException() {
        super(ERROR_CODE);
    }

    public EntityCreateException(String message) {
        super(ERROR_CODE, message);
    }

    public EntityCreateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EntityCreateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
