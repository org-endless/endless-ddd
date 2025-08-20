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
        super(null, ERROR_CODE, null, null);
    }

    public ValueException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ValueException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ValueException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ValueException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ValueException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public ValueException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
