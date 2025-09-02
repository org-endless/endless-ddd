package org.endless.ddd.starter.common.exception.ddd.domain.type;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * EnumException
 * <p>
 * create 2024/09/29 11:42
 * <p>
 * update 2024/11/17 16:14
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class EnumException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DEM0000;

    public EnumException() {
        super(null, ERROR_CODE, null, null);
    }

    public EnumException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public EnumException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public EnumException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public EnumException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public EnumException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public EnumException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
