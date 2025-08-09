package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.exception.common.NotFoundException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * CommandHandlerException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/11/17 16:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class CommandHandlerNotFoundException extends NotFoundException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DCD0010;

    public CommandHandlerNotFoundException() {
        super(ERROR_CODE);
    }

    public CommandHandlerNotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandHandlerNotFoundException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandHandlerNotFoundException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
