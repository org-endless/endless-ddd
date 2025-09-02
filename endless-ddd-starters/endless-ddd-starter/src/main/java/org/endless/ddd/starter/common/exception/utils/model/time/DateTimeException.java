package org.endless.ddd.starter.common.exception.utils.model.time;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DateTimeException
 * <p>
 * create 2025/08/21 03:00
 * <p>
 * update 2025/08/21 03:00
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class DateTimeException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0022;

    public DateTimeException() {
        super(null, ERROR_CODE, null, null);
    }

    public DateTimeException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DateTimeException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DateTimeException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DateTimeException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DateTimeException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
