package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.ReqTransferValidateException;

/**
 * CommandReqTransferValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/11/16 23:35
 *
 * @author Deng Haozhi
 * @see ReqTransferValidateException
 * @since 1.0.0
 */
public class CommandReqTransferValidateException extends ReqTransferValidateException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1101");

    public CommandReqTransferValidateException() {
        super(ERROR_CODE);
    }

    public CommandReqTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandReqTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandReqTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
