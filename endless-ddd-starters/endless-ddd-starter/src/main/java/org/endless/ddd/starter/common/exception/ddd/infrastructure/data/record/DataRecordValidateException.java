package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DataRecordValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/07 23:46
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordValidateException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDR0002;

    public DataRecordValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
