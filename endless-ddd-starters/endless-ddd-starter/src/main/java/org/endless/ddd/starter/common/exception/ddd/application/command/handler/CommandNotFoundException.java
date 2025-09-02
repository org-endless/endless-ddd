package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.NotFoundException;

/**
 * CommandFailedException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2025/08/11 18:50
 *
 * @author Deng Haozhi
 * @see NotFoundException
 * @since 1.0.0
 */
public class CommandNotFoundException extends NotFoundException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DCD0010;

    public CommandNotFoundException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandNotFoundException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandNotFoundException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandNotFoundException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandNotFoundException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandNotFoundException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
