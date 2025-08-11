package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferNullException;

/**
 * CommandReqTransferNullException
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
        super(ERROR_CODE);
    }

    public CommandRespTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandRespTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandRespTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
