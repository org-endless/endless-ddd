package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO2101;

    public CommandRespTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandRespTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandRespTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandRespTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandRespTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandRespTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
