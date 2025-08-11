package org.endless.ddd.starter.common.exception.ddd.application.command.transfer;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.ddd.common.ReqTransferNullException;

/**
 * CommandReqTransferNullException
 * <p>
 * create 2024/09/29 11:19
 * <p>
 * update 2025/08/11 19:25
 *
 * @author Deng Haozhi
 * @see ReqTransferNullException
 * @since 1.0.0
 */
public class CommandReqTransferNullException extends ReqTransferNullException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DTO1100");

    public CommandReqTransferNullException() {
        super(ERROR_CODE);
    }

    public CommandReqTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public CommandReqTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CommandReqTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
