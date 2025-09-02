package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.DCD9002;

    public CommandRemoveUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandRemoveUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandRemoveUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandRemoveUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandRemoveUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandRemoveUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
