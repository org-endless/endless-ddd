package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.RespTransferValidateException;

/**
 * CommandRespTransferValidateException
 * <p>
 * create 2025/08/11 19:25
 * <p>
 * update 2025/08/11 19:36
 *
 * @author Deng Haozhi
 * @see RespTransferValidateException
 * @since 1.0.0
 */
public class CommandRespTransferValidateException extends RespTransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO2101");

    public CommandRespTransferValidateException() {
        super(ERROR_CODE);
    }

    public CommandRespTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandRespTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandRespTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
