package org.endless.ddd.starter.common.exception.utils.crypto.rsa;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM2SignException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class RSASignException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0113");

    public RSASignException() {
        super(null, ERROR_CODE, null, null);
    }

    public RSASignException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RSASignException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RSASignException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RSASignException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RSASignException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
