package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.DCD9000;

    public CommandUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public CommandUnknowException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
