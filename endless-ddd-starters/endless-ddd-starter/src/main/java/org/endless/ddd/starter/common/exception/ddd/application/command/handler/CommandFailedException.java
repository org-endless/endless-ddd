package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * CommandFailedException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2025/08/11 18:50
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class CommandFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD0000");

    public CommandFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public CommandFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
