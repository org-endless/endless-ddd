package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DataManagerFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/21 00:12
 *
 * @author Deng Haozhi
 * @see DataManagerFailedException
 * @since 1.0.0
 */
public class DataManagerParameterNullException extends DataManagerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDM8000");

    public DataManagerParameterNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerParameterNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerParameterNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerParameterNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerParameterNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerParameterNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
