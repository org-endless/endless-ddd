package org.endless.ddd.starter.common.exception.ddd.domain.service;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * ServiceFailedException
 * <p>
 * create 2024/09/29 11:33
 * <p>
 * update 2025/01/27 03:57
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class ServiceFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DSV0000;

    public ServiceFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public ServiceFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ServiceFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ServiceFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ServiceFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ServiceFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public ServiceFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
