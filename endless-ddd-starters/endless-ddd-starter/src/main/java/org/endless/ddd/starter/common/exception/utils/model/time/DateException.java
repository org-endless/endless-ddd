package org.endless.ddd.starter.common.exception.utils.model.time;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DateException
 * <p>
 * create 2025/08/21 03:02
 * <p>
 * update 2025/08/21 03:04
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DateException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0021");

    public DateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
