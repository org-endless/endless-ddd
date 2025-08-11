package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * DrivenTransferValidateException
 * <p>
 * create 2025/01/09 17:55
 * <p>
 * update 2025/01/09 17:56
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DrivenTransferValidateException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DTO0301;

    public DrivenTransferValidateException() {
        super(ERROR_CODE);
    }

    public DrivenTransferValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public DrivenTransferValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DrivenTransferValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
