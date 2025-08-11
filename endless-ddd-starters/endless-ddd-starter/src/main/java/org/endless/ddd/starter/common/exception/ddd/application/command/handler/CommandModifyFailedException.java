package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommandModifyFailedException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/11/17 16:08
 *
 * @author Deng Haozhi
 * @see CommandFailedException
 * @since 1.0.0
 */
public class CommandModifyFailedException extends CommandFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD0003");

    public CommandModifyFailedException() {
        super(ERROR_CODE);
    }

    public CommandModifyFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandModifyFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandModifyFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
