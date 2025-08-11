package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * CryptoException
 * <p>
 * create 2025/07/21 01:09
 * <p>
 * update 2025/07/21 01:09
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class CryptoException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.UTL0002;

    public CryptoException() {
        super(ERROR_CODE);
    }

    public CryptoException(String message) {
        super(ERROR_CODE, message);
    }

    public CryptoException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public CryptoException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
