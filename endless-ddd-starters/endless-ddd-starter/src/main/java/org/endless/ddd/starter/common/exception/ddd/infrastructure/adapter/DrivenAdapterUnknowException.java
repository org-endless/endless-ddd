package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * DrivenAdapterUnknowException
 * <p>
 * create 2025/08/20 23:59
 * <p>
 * update 2025/08/21 00:01
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class DrivenAdapterUnknowException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDA9000");

    public DrivenAdapterUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenAdapterUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenAdapterUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenAdapterUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenAdapterUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenAdapterUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public DrivenAdapterUnknowException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
