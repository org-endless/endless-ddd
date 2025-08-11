package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * RestResponseException
 * <p>
 * create 2025/03/19 16:53
 * <p>
 * update 2025/03/19 16:53
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class RestResponseException extends RestException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.RES0020;

    public RestResponseException() {
        super(ERROR_CODE);
    }

    public RestResponseException(String message) {
        super(ERROR_CODE, message);
    }

    public RestResponseException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RestResponseException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RestResponseException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public RestResponseException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public RestResponseException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RestResponseException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
