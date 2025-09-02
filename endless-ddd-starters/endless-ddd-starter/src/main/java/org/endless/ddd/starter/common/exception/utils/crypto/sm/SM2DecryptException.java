package org.endless.ddd.starter.common.exception.utils.crypto.sm;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.utils.crypto.CryptoException;

/**
 * SM2DecryptException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2024/11/16 23:54
 *
 * @author Deng Haozhi
 * @see CryptoException
 * @since 1.0.0
 */
public class SM2DecryptException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0103;

    public SM2DecryptException() {
        super(null, ERROR_CODE, null, null);
    }

    public SM2DecryptException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public SM2DecryptException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public SM2DecryptException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public SM2DecryptException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public SM2DecryptException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
