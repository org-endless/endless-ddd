package org.endless.ddd.starter.common.exception.utils.crypto.sm;

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
public class SM2SignException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0104");

    public SM2SignException() {
        super(null, ERROR_CODE, null, null);
    }

    public SM2SignException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SM2SignException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SM2SignException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SM2SignException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SM2SignException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
