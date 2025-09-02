package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * CryptoException
 * <p>
 * create 2025/07/21 01:09
 * <p>
 * update 2025/08/21 01:55
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class CryptoException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0100;

    public CryptoException() {
        super(null, ERROR_CODE, null, null);
    }

    public CryptoException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public CryptoException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public CryptoException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public CryptoException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public CryptoException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public CryptoException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
