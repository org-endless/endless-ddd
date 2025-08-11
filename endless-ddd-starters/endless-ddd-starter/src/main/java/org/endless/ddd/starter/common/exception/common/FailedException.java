package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * FailedException
 * <p>
 * create 2024/12/05 02:08
 * <p>
 * update 2025/01/27 03:57
 * update 2025/03/01 23:27
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class FailedException extends AbstractException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.FAILURE;

    public FailedException() {
        super(ERROR_CODE);
    }

    public FailedException(String message) {
        super(ERROR_CODE, message);
    }

    public FailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public FailedException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public FailedException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public FailedException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public FailedException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
