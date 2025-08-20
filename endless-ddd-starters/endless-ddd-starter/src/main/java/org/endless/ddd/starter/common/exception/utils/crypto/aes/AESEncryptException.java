package org.endless.ddd.starter.common.exception.utils.crypto.aes;

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
public class AESEncryptException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0121");

    public AESEncryptException() {
        super(null, ERROR_CODE, null, null);
    }

    public AESEncryptException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AESEncryptException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AESEncryptException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AESEncryptException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AESEncryptException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
