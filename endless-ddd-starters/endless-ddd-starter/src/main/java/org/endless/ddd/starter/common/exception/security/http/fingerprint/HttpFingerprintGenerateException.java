package org.endless.ddd.starter.common.exception.security.http.fingerprint;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.SecurityException;

/**
 * HttpFingerprintGenerateException
 * <p>
 * create 2024/12/26 10:07
 * <p>
 * update 2024/12/26 10:08
 *
 * @author Deng Haozhi
 * @see SecurityException
 * @since 1.0.0
 */
public class HttpFingerprintGenerateException extends SecurityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0051");

    public HttpFingerprintGenerateException() {
        super(null, ERROR_CODE, null, null);
    }

    public HttpFingerprintGenerateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public HttpFingerprintGenerateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public HttpFingerprintGenerateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public HttpFingerprintGenerateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public HttpFingerprintGenerateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
