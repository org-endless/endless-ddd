package org.endless.ddd.starter.common.exception.utils.model;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DecimalFormatException
 * <p>
 * create 2025/01/11 00:11
 * <p>
 * update 2025/01/11 00:11
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class DecimalOutOfRangeException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0014");

    public DecimalOutOfRangeException() {
        super(ERROR_CODE);
    }

    public DecimalOutOfRangeException(String message) {
        super(ERROR_CODE, message);
    }

    public DecimalOutOfRangeException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DecimalOutOfRangeException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
