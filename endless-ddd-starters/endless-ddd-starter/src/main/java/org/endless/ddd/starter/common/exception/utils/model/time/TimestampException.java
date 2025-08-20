package org.endless.ddd.starter.common.exception.utils.model.time;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * TimeStampException
 * <p>
 * create 2024/12/04 14:45
 * <p>
 * update 2025/08/21 03:02
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class TimestampException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0020");

    public TimestampException() {
        super(null, ERROR_CODE, null, null);
    }

    public TimestampException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public TimestampException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public TimestampException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public TimestampException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public TimestampException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
