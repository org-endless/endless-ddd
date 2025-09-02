package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DataManagerParameterValidateException
 * <p>
 * create 2025/08/21 00:11
 * <p>
 * update 2025/08/21 00:12
 *
 * @author Deng Haozhi
 * @see DataManagerFailedException
 * @since 1.0.0
 */
public class DataManagerParameterValidateException extends DataManagerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDM8001;

    public DataManagerParameterValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerParameterValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerParameterValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerParameterValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerParameterValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerParameterValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
