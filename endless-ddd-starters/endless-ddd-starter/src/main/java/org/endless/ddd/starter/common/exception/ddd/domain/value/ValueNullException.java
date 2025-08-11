package org.endless.ddd.starter.common.exception.ddd.domain.value;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * ValueNullException
 * <p>
 * create 2025/08/11 20:13
 * <p>
 * update 2025/08/11 20:13
 *
 * @author Deng Haozhi
 * @see ValueException
 * @since 1.0.0
 */
public class ValueNullException extends ValueException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DVO0001");

    public ValueNullException() {
        super(ERROR_CODE);
    }

    public ValueNullException(String message) {
        super(ERROR_CODE, message);
    }

    public ValueNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ValueNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
