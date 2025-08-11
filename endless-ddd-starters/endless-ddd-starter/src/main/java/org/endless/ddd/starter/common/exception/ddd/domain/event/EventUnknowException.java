package org.endless.ddd.starter.common.exception.ddd.domain.event;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * EventUnknowException
 * <p>
 * create 2025/08/11 19:49
 * <p>
 * update 2025/08/11 19:49
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class EventUnknowException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEV9000");

    public EventUnknowException() {
        super(ERROR_CODE);
    }

    public EventUnknowException(String message) {
        super(ERROR_CODE, message);
    }

    public EventUnknowException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EventUnknowException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public EventUnknowException(ErrorCode errorCode) {
        super(errorCode);
    }

    public EventUnknowException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public EventUnknowException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public EventUnknowException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
