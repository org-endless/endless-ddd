package org.endless.ddd.starter.common.exception.utils.model.decimal;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

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
public class DecimalOutOfRangeException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0013;

    public DecimalOutOfRangeException() {
        super(null, ERROR_CODE, null, null);
    }

    public DecimalOutOfRangeException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DecimalOutOfRangeException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DecimalOutOfRangeException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DecimalOutOfRangeException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DecimalOutOfRangeException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
