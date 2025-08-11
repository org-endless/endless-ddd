package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * RestException
 * <p>
 * create 2024/09/08 19:49
 * <p>
 * update 2025/08/10 21:41
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RestException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.RES0000;

    public RestException() {
        super(ERROR_CODE);
    }

    public RestException(String message) {
        super(ERROR_CODE, message);
    }

    public RestException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RestException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RestException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public RestException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public RestException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RestException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
