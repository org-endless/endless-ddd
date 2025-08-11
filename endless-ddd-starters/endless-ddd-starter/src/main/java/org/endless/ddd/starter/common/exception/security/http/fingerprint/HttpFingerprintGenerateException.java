package org.endless.ddd.starter.common.exception.security.http.fingerprint;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * HttpFingerprintGenerateException
 * <p>
 * create 2024/12/26 10:07
 * <p>
 * update 2024/12/26 10:08
 *
 * @author Deng Haozhi
 * @see SecurityFailedException
 * @since 1.0.0
 */
public class HttpFingerprintGenerateException extends SecurityFailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.SEC0030;

    public HttpFingerprintGenerateException() {
        super(ERROR_CODE);
    }

    public HttpFingerprintGenerateException(String message) {
        super(ERROR_CODE, message);
    }

    public HttpFingerprintGenerateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public HttpFingerprintGenerateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
