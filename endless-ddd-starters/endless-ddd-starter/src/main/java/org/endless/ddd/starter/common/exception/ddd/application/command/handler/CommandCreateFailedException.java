package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * CommandCreateFailedException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/11/17 16:07
 *
 * @author Deng Haozhi
 * @see CommandFailedException
 * @since 1.0.0
 */
public class CommandCreateFailedException extends CommandFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DCD0001;

    public CommandCreateFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandCreateFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandCreateFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandCreateFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandCreateFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandCreateFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
