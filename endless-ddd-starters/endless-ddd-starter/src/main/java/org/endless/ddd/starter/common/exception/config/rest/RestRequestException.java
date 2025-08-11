package org.endless.ddd.starter.common.exception.config.rest;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * RestRequestException
 * <p>
 * create 2025/08/10 22:33
 * <p>
 * update 2025/08/10 22:33
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class RestRequestException extends RestException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.RES0010;

    public RestRequestException() {
        super(ERROR_CODE);
    }

    public RestRequestException(String message) {
        super(ERROR_CODE, message);
    }

    public RestRequestException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public RestRequestException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }

    public RestRequestException(ErrorCommonCode errorCode) {
        super(errorCode);
    }

    public RestRequestException(ErrorCommonCode errorCode, String message) {
        super(errorCode, message);
    }

    public RestRequestException(ErrorCommonCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RestRequestException(ErrorCommonCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
