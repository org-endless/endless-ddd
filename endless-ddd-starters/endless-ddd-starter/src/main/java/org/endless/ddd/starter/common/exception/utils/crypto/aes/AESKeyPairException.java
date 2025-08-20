package org.endless.ddd.starter.common.exception.utils.crypto.aes;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM2KeyPairException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class AESKeyPairException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0120");

    public AESKeyPairException() {
        super(null, ERROR_CODE, null, null);
    }

    public AESKeyPairException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AESKeyPairException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AESKeyPairException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AESKeyPairException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AESKeyPairException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
