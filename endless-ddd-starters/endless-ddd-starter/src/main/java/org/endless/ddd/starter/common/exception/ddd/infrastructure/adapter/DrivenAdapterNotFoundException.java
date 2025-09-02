package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DrivenAdapterNotFoundException
 * <p>
 * create 2025/08/27 13:55
 * <p>
 * update 2025/08/27 13:56
 *
 * @author Deng Haozhi
 * @see DrivenAdapterFailedException
 * @since 1.0.0
 */
public class DrivenAdapterNotFoundException extends DrivenAdapterFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDA0010;

    public DrivenAdapterNotFoundException() {
        super(null, ERROR_CODE, null, null);
    }

    public DrivenAdapterNotFoundException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DrivenAdapterNotFoundException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DrivenAdapterNotFoundException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DrivenAdapterNotFoundException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DrivenAdapterNotFoundException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
