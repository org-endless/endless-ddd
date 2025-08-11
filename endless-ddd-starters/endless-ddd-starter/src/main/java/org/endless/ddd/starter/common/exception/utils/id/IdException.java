package org.endless.ddd.starter.common.exception.utils.id;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * IdException
 * <p>
 * create 2024/12/25 11:17
 * <p>
 * update 2024/12/25 11:17
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class IdException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0000");

    public IdException() {
        super(ERROR_CODE);
    }

    public IdException(String message) {
        super(ERROR_CODE, message);
    }

    public IdException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public IdException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
