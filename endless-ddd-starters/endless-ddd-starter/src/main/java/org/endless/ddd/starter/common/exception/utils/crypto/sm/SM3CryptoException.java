package org.endless.ddd.starter.common.exception.utils.crypto.sm;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM3CryptoException
 * <p>
 * create 2024/11/18 21:23
 * <p>
 * update 2025/07/19 03:48
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class SM3CryptoException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0106");

    public SM3CryptoException() {
        super(null, ERROR_CODE, null, null);
    }

    public SM3CryptoException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SM3CryptoException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SM3CryptoException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SM3CryptoException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SM3CryptoException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
