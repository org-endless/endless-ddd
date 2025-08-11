package org.endless.ddd.starter.common.exception.ddd.domain.value;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * ValueValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/11/16 23:40
 *
 * @author Deng Haozhi
 * @see ValueException
 * @since 1.0.0
 */
public class ValueValidateException extends ValueException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DVO0002");

    public ValueValidateException() {
        super(ERROR_CODE);
    }

    public ValueValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public ValueValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ValueValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
