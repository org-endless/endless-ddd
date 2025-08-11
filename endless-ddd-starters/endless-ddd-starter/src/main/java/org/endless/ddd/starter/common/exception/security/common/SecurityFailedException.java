package org.endless.ddd.starter.common.exception.security.common;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * SecurityFailedException
 * <p>
 * create 2024/12/05 18:10
 * <p>
 * update 2024/12/31 23:39
 *
 * @author Deng Haozhi
 * @see AbstractSecurityException
 * @since 1.0.0
 */
public class SecurityFailedException extends AbstractSecurityException {

    public SecurityFailedException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public SecurityFailedException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public SecurityFailedException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public SecurityFailedException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
