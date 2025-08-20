package org.endless.ddd.starter.common.exception.utils.model.decimal;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DecimalFormatException
 * <p>
 * create 2025/01/11 00:11
 * <p>
 * update 2025/01/11 00:11
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class DecimalFormatException extends DecimalException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0012");

    public DecimalFormatException() {
        super(null, ERROR_CODE, null, null);
    }

    public DecimalFormatException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DecimalFormatException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DecimalFormatException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DecimalFormatException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DecimalFormatException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
