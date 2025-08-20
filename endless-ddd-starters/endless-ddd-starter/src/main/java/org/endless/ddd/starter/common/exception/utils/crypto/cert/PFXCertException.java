package org.endless.ddd.starter.common.exception.utils.crypto.cert;

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
public class PFXCertException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0131");

    public PFXCertException() {
        super(null, ERROR_CODE, null, null);
    }

    public PFXCertException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PFXCertException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PFXCertException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PFXCertException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PFXCertException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
