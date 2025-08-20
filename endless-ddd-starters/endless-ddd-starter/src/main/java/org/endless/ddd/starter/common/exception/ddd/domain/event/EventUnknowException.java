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
        super(null, ERROR_CODE, null, null);
    }

    public EventUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EventUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EventUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EventUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EventUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public EventUnknowException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
