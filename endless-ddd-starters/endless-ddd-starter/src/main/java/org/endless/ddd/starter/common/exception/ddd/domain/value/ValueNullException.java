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
        super(null, ERROR_CODE, null, null);
    }

    public ValueNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ValueNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ValueNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ValueNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ValueNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
