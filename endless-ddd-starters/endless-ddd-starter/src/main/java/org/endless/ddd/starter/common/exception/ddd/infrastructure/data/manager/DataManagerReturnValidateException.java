package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DataManagerReturnValidateException
 * <p>
 * create 2025/08/21 00:11
 * <p>
 * update 2025/08/21 00:12
 *
 * @author Deng Haozhi
 * @see DataManagerFailedException
 * @since 1.0.0
 */
public class DataManagerReturnValidateException extends DataManagerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDM8101;

    public DataManagerReturnValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerReturnValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerReturnValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerReturnValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerReturnValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerReturnValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
