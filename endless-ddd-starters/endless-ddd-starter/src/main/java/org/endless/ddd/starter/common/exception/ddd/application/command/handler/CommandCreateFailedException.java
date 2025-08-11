package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD0001");

    public CommandCreateFailedException() {
        super(ERROR_CODE);
    }

    public CommandCreateFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandCreateFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandCreateFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
