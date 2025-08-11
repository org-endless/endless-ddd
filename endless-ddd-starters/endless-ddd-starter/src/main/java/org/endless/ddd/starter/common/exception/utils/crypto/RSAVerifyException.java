package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * SM2VerifyException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RSAVerifyException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0134");

    public RSAVerifyException() {
        super(ERROR_CODE);
    }

    public RSAVerifyException(String message) {
        super(ERROR_CODE, message);
    }

    public RSAVerifyException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RSAVerifyException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
