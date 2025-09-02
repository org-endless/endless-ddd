package org.endless.ddd.starter.common.exception.utils.crypto.aes;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * AESDecryptException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2024/11/16 23:54
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class AESDecryptException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0122;

    public AESDecryptException() {
        super(null, ERROR_CODE, null, null);
    }

    public AESDecryptException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public AESDecryptException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public AESDecryptException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public AESDecryptException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public AESDecryptException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
