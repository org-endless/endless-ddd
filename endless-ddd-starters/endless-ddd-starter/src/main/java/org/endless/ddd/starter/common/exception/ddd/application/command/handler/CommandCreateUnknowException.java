package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommandCreateUnknowException
 * <p>
 * create 2025/08/11 18:51
 * <p>
 * update 2025/08/11 18:52
 *
 * @author Deng Haozhi
 * @see CommandUnknowException
 * @since 1.0.0
 */
public class CommandCreateUnknowException extends CommandUnknowException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD9001");

    public CommandCreateUnknowException() {
        super(ERROR_CODE);
    }

    public CommandCreateUnknowException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandCreateUnknowException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandCreateUnknowException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
