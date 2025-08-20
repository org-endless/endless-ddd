package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommandRemoveFailedException
 * <p>
 * create 2024/11/10 13:53
 * <p>
 * update 2024/11/17 16:08
 *
 * @author Deng Haozhi
 * @see CommandFailedException
 * @since 1.0.0
 */
public class CommandRemoveFailedException extends CommandFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD0002");

    public CommandRemoveFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandRemoveFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandRemoveFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandRemoveFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandRemoveFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandRemoveFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
