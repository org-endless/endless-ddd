package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * FailedException
 * <p>
 * create 2024/12/05 02:08
 * <p>
 * update 2025/01/27 03:57
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class NotFoundException extends AbstractException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.NOT_FND;

    public NotFoundException() {
        super(ERROR_CODE);
    }

    public NotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public NotFoundException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public NotFoundException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public NotFoundException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public NotFoundException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
