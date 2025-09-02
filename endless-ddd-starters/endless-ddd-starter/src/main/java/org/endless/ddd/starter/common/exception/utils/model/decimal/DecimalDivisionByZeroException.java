package org.endless.ddd.starter.common.exception.utils.model.decimal;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DecimalFormatException
 * <p>
 * create 2025/01/11 00:11
 * <p>
 * update 2025/01/11 00:28
 *
 * @author Deng Haozhi
 * @see DecimalException
 * @since 1.0.0
 */
public class DecimalDivisionByZeroException extends DecimalException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0015;

    public DecimalDivisionByZeroException() {
        super(null, ERROR_CODE, null, null);
    }

    public DecimalDivisionByZeroException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DecimalDivisionByZeroException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DecimalDivisionByZeroException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DecimalDivisionByZeroException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DecimalDivisionByZeroException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
