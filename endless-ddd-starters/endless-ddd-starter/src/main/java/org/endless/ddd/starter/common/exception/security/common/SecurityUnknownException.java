package org.endless.ddd.starter.common.exception.security.common;


import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * SecurityUnknownException
 * <p>
 * create 2024/12/05 18:11
 * <p>
 * update 2024/12/05 18:11
 *
 * @author Deng Haozhi
 * @see AbstractSecurityException
 * @since 1.0.0
 */
public class SecurityUnknownException extends AbstractSecurityException {

    public SecurityUnknownException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public SecurityUnknownException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public SecurityUnknownException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public SecurityUnknownException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
