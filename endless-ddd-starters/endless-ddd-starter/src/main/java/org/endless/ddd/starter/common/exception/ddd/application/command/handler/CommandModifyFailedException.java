package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommandModifyFailedException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/11/17 16:08
 *
 * @author Deng Haozhi
 * @see CommandFailedException
 * @since 1.0.0
 */
public class CommandModifyFailedException extends CommandFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DCD0003");

    public CommandModifyFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandModifyFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandModifyFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandModifyFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandModifyFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandModifyFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
