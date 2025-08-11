package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * DrivenReqTransferNullException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DrivenReqTransferNullException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DTS0300;

    public DrivenReqTransferNullException() {
        super(ERROR_CODE);
    }

    public DrivenReqTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public DrivenReqTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DrivenReqTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
