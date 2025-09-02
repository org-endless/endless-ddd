package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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

    private static final ErrorCode ERROR_CODE = ErrorCode.DCD9001;

    public CommandCreateUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandCreateUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandCreateUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandCreateUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandCreateUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandCreateUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
