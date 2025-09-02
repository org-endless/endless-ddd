package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.page;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * PageException
 * <p>
 * create 2024/09/12 12:18
 * <p>
 * update 2025/08/21 00:19
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class PageException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DPG0000;

    public PageException() {
        super(null, ERROR_CODE, null, null);
    }

    public PageException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PageException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PageException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PageException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PageException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public PageException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
