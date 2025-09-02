package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DataRecordNullException
 * <p>
 * create 2025/08/07 23:46
 * <p>
 * update 2025/08/07 23:56
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordNullException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDR0001;

    public DataRecordNullException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordNullException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordNullException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordNullException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordNullException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordNullException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
