package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommandModifyUnknowException
 * <p>
 * create 2025/08/11 18:53
 * <p>
 * update 2025/08/11 18:53
 *
 * @author Deng Haozhi
 * @see CommandUnknowException
 * @since 1.0.0
 */
public class CommandModifyUnknowException extends CommandUnknowException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD9003");

    public CommandModifyUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandModifyUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandModifyUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandModifyUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandModifyUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandModifyUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
