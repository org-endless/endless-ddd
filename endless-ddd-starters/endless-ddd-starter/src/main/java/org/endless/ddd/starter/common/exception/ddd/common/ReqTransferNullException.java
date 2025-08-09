package org.endless.ddd.starter.common.exception.ddd.common;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * ReqTransferNullException
 * <p>
 * create 2025/01/02 14:18
 * <p>
 * update 2025/01/02 14:18
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class ReqTransferNullException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DTS0000;

    public ReqTransferNullException() {
        super(ERROR_CODE);
    }

    public ReqTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public ReqTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ReqTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
