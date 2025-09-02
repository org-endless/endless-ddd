package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DrivenAdapterException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/21 00:00
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DrivenAdapterFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDA0000;

    public DrivenAdapterFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenAdapterFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenAdapterFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenAdapterFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenAdapterFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenAdapterFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public DrivenAdapterFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
