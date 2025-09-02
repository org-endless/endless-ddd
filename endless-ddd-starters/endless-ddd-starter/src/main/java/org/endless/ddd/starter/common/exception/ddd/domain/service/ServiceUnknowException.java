package org.endless.ddd.starter.common.exception.ddd.domain.service;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * ServiceUnknowException
 * <p>
 * create 2025/08/11 19:51
 * <p>
 * update 2025/08/11 19:52
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class ServiceUnknowException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DSV9000;

    public ServiceUnknowException() {
        super(null, ERROR_CODE, null, null);
    }

    public ServiceUnknowException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ServiceUnknowException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ServiceUnknowException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ServiceUnknowException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ServiceUnknowException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public ServiceUnknowException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
