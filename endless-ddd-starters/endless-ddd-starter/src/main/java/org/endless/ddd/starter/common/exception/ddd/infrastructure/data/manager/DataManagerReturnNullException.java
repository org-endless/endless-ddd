package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DataManagerReturnNullException
 * <p>
 * create 2025/08/21 00:11
 * <p>
 * update 2025/08/21 00:12
 *
 * @author Deng Haozhi
 * @see DataManagerFailedException
 * @since 1.0.0
 */
public class DataManagerReturnNullException extends DataManagerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDM8100");

    public DataManagerReturnNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerReturnNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerReturnNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerReturnNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerReturnNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerReturnNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
