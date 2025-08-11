package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * SM2EncryptException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class SM2EncryptException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.UTL0101;

    public SM2EncryptException() {
        super(ERROR_CODE);
    }

    public SM2EncryptException(String message) {
        super(ERROR_CODE, message);
    }

    public SM2EncryptException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public SM2EncryptException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
