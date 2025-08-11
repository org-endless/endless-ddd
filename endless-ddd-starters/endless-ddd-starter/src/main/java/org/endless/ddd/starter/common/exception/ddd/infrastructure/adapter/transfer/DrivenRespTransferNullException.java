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
public class DrivenRespTransferNullException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DTR0300;

    public DrivenRespTransferNullException() {
        super(ERROR_CODE);
    }

    public DrivenRespTransferNullException(String message) {
        super(ERROR_CODE, message);
    }

    public DrivenRespTransferNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DrivenRespTransferNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
