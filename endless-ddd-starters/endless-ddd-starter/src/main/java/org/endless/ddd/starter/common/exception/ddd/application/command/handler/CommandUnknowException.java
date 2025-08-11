package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * CommandUnknowException
 * <p>
 * create 2025/08/11 18:49
 * <p>
 * update 2025/08/11 18:50
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class CommandUnknowException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD9000");

    public CommandUnknowException() {
        super(ERROR_CODE);
    }

    public CommandUnknowException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandUnknowException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandUnknowException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public CommandUnknowException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CommandUnknowException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public CommandUnknowException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public CommandUnknowException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
