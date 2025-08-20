package org.endless.ddd.starter.common.exception.utils.model.decimal;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DecimalFormatException
 * <p>
 * create 2025/01/11 00:11
 * <p>
 * update 2025/01/11 00:25
 *
 * @author Deng Haozhi
 * @see DecimalException
 * @since 1.0.0
 */
public class DecimalNullException extends DecimalException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0011");

    public DecimalNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public DecimalNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DecimalNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DecimalNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DecimalNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DecimalNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
