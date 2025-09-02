package org.endless.ddd.starter.common.exception.utils.crypto.sm;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM2VerifyException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class SM2VerifyException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0105;

    public SM2VerifyException() {
        super(null, ERROR_CODE, null, null);
    }

    public SM2VerifyException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SM2VerifyException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SM2VerifyException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SM2VerifyException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SM2VerifyException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
