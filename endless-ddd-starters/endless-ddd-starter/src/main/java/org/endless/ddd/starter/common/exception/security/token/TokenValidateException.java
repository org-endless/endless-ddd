package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * TokenValidateException
 * <p>
 * create 2024/12/25 13:52
 * <p>
 * update 2024/12/25 13:53
 *
 * @author Deng Haozhi
 * @see SecurityFailedException
 * @since 1.0.0
 */
public class TokenValidateException extends SecurityFailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.SEC0013;

    public TokenValidateException() {
        super(ERROR_CODE);
    }

    public TokenValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public TokenValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public TokenValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
