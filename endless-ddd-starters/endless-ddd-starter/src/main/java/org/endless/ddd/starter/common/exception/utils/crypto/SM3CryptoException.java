package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * SM3CryptoException
 * <p>
 * create 2024/11/18 21:23
 * <p>
 * update 2025/07/19 03:48
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class SM3CryptoException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0110");

    public SM3CryptoException() {
        super(ERROR_CODE);
    }

    public SM3CryptoException(String message) {
        super(ERROR_CODE, message);
    }

    public SM3CryptoException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public SM3CryptoException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
