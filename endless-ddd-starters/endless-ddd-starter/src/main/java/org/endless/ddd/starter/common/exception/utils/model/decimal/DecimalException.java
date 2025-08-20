package org.endless.ddd.starter.common.exception.utils.model.decimal;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DecimalException
 * <p>
 * create 2025/08/21 02:49
 * <p>
 * update 2025/08/21 02:49
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DecimalException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0010");

    public DecimalException() {
        super(null, ERROR_CODE, null, null);
    }

    public DecimalException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DecimalException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DecimalException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DecimalException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DecimalException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public DecimalException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }

}
