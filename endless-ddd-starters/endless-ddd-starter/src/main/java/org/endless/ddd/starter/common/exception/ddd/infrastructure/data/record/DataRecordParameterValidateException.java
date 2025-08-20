package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DataRecordParameterValidateException
 * <p>
 * create 2025/08/21 01:29
 * <p>
 * update 2025/08/21 01:33
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordParameterValidateException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDR8001");

    public DataRecordParameterValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordParameterValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordParameterValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordParameterValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordParameterValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordParameterValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
