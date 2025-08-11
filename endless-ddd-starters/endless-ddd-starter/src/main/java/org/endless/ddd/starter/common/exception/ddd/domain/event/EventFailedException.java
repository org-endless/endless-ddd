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
        super(ERROR_CODE);
    }

    public EventFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public EventFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public EventFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public EventFailedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public EventFailedException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public EventFailedException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public EventFailedException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
