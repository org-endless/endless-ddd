package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * SM2KeyPairException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RSAKeyPairException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0130");

    public RSAKeyPairException() {
        super(ERROR_CODE);
    }

    public RSAKeyPairException(String message) {
        super(ERROR_CODE, message);
    }

    public RSAKeyPairException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RSAKeyPairException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
