package org.endless.ddd.starter.common.exception.utils.crypto.rsa;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM2EncryptException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class RSAEncryptException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0111");

    public RSAEncryptException() {
        super(null, ERROR_CODE, null, null);
    }

    public RSAEncryptException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public RSAEncryptException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public RSAEncryptException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public RSAEncryptException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public RSAEncryptException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
