package org.endless.ddd.starter.common.exception.ddd.domain.service;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
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

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DSV9000");

    public ServiceUnknowException() {
        super(ERROR_CODE);
    }

    public ServiceUnknowException(String message) {
        super(ERROR_CODE, message);
    }

    public ServiceUnknowException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public ServiceUnknowException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public ServiceUnknowException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ServiceUnknowException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ServiceUnknowException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public ServiceUnknowException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
