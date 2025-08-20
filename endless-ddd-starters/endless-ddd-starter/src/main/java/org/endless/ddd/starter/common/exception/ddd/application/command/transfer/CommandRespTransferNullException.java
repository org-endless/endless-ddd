package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferNullException;

/**
 * CommandRespTransferNullException
 * <p>
 * create 2024/09/29 11:19
 * <p>
 * update 2024/11/17 16:09
 *
 * @author Deng Haozhi
 * @see RespTransferNullException
 * @since 1.0.0
 */
public class CommandRespTransferNullException extends RespTransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2100");

    public CommandRespTransferNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandRespTransferNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandRespTransferNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandRespTransferNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandRespTransferNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandRespTransferNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
