package org.endless.ddd.starter.common.exception.security.token;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * TokenBadRequestException
 * <p>
 * create 2024/12/06 00:26
 * <p>
 * update 2024/12/06 00:27
 *
 * @author Deng Haozhi
 * @see SecurityFailedException
 * @since 1.0.0
 */
public class TokenBadRequestException extends SecurityFailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.SEC0010;

    public TokenBadRequestException() {
        super(ERROR_CODE);
    }

    public TokenBadRequestException(String message) {
        super(ERROR_CODE, message);
    }

    public TokenBadRequestException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public TokenBadRequestException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
