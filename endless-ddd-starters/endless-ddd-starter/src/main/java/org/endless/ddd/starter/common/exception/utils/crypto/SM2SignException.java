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
public class SM2SignException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0103");

    public SM2SignException() {
        super(ERROR_CODE);
    }

    public SM2SignException(String message) {
        super(ERROR_CODE, message);
    }

    public SM2SignException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public SM2SignException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
