package org.endless.ddd.starter.common.exception.security.identity;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.security.SecurityException;

/**
 * IdentityNotVerifiedException
 * <p>
 * create 2025/01/09 17:42
 * <p>
 * update 2025/08/21 03:48
 * @see java.lang.SecurityException
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class IdentityNotVerifiedException extends SecurityException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC1001");

    public IdentityNotVerifiedException() {
        super(null, ERROR_CODE, null, null);
    }

    public IdentityNotVerifiedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public IdentityNotVerifiedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public IdentityNotVerifiedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public IdentityNotVerifiedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public IdentityNotVerifiedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
