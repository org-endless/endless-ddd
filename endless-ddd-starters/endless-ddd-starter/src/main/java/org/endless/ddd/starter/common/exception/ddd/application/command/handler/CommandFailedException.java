package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * CommandFailedException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2025/08/11 18:50
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class CommandFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD0000");

    public CommandFailedException() {
        super(ERROR_CODE);
    }

    public CommandFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public CommandFailedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CommandFailedException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public CommandFailedException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public CommandFailedException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
