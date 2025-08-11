package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommandRemoveUnknowException
 * <p>
 * create 2025/08/11 18:54
 * <p>
 * update 2025/08/11 18:54
 *
 * @author Deng Haozhi
 * @see CommandUnknowException
 * @since 1.0.0
 */
public class CommandRemoveUnknowException extends CommandUnknowException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD9002");

    public CommandRemoveUnknowException() {
        super(ERROR_CODE);
    }

    public CommandRemoveUnknowException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandRemoveUnknowException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandRemoveUnknowException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
