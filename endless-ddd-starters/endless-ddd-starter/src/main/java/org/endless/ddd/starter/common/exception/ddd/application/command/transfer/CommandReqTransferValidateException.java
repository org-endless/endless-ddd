package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.DTO1101;

    public CommandReqTransferValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public CommandReqTransferValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CommandReqTransferValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CommandReqTransferValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CommandReqTransferValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CommandReqTransferValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
