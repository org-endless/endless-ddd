package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.page;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * PageFindException
 * <p>
 * create 2024/09/12 12:19
 * <p>
 * update 2024/09/12 12:20
 *
 * @author Deng Haozhi
 * @see PageException
 * @since 1.0.0
 */
public class PageFindException extends PageException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DPG1001;

    public PageFindException() {
        super(null, ERROR_CODE, null, null);
    }

    public PageFindException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public PageFindException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public PageFindException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public PageFindException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public PageFindException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public PageFindException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
