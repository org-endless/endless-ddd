package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * UnknownException
 * <p>
 * create 2024/12/05 02:05
 * <p>
 * update 2024/12/05 02:07
 * update 2025/07/19 02:56
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class UnknownException extends AbstractException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.UNKNOWN;

    public UnknownException() {
        super(ERROR_CODE);
    }

    public UnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public UnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public UnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public UnknownException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public UnknownException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public UnknownException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public UnknownException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
