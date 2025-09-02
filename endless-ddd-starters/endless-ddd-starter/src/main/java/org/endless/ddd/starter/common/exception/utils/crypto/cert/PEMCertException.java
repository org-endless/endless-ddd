package org.endless.ddd.starter.common.exception.utils.crypto.cert;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
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
public class PEMCertException extends CryptoException {

    private static final ErrorCode ERROR_CODE = ErrorCode.UTL0130;

    public PEMCertException() {
        super(null, ERROR_CODE, null, null);
    }

    public PEMCertException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PEMCertException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PEMCertException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PEMCertException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PEMCertException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
