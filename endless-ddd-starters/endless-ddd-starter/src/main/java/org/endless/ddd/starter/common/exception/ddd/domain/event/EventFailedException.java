package org.endless.ddd.starter.common.exception.ddd.domain.event;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * EventFailedException
 * <p>
 * create 2024/09/29 11:32
 * <p>
 * update 2024/11/17 16:13
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class EventFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DEV0000");

    public EventFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public EventFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EventFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EventFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EventFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EventFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public EventFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
