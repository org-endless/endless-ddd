package org.endless.ddd.starter.common.exception.ddd.domain.value;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * ValueException
 * <p>
 * create 2024/09/29 11:33
 * <p>
 * update 2025/08/11 20:12
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class ValueException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DVO0000");

    public ValueException() {
        super(ERROR_CODE);
    }

    public ValueException(String message) {
        super(ERROR_CODE, message);
    }

    public ValueException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ValueException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public ValueException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ValueException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ValueException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public ValueException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
