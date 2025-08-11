package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * SM2SignException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2025/03/01 23:28
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RSASignException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0133");

    public RSASignException() {
        super(ERROR_CODE);
    }

    public RSASignException(String message) {
        super(ERROR_CODE, message);
    }

    public RSASignException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RSASignException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
