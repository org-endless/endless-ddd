package org.endless.ddd.starter.common.exception.ddd.domain.type;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * EnumException
 * <p>
 * create 2024/09/29 11:42
 * <p>
 * update 2024/11/17 16:14
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class EnumException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DEM0000;

    public EnumException() {
        super(ERROR_CODE);
    }

    public EnumException(String message) {
        super(ERROR_CODE, message);
    }

    public EnumException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EnumException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
