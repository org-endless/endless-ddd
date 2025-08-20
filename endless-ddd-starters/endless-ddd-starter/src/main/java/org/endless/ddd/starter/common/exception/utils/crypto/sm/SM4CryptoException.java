package org.endless.ddd.starter.common.exception.utils.crypto.sm;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM4CryptoException
 * <p>
 * create 2024/11/18 19:43
 * <p>
 * update 2025/07/19 03:46
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class SM4CryptoException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0107");

    public SM4CryptoException() {
        super(null, ERROR_CODE, null, null);
    }

    public SM4CryptoException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SM4CryptoException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SM4CryptoException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SM4CryptoException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SM4CryptoException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
