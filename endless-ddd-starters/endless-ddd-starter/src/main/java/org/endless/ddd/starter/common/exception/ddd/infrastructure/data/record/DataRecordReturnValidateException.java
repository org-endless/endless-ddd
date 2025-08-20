package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DataRecordReturnValidateException
 * <p>
 * create 2025/08/21 01:30
 * <p>
 * update 2025/08/21 01:35
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordReturnValidateException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDR8101");

    public DataRecordReturnValidateException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordReturnValidateException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordReturnValidateException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordReturnValidateException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordReturnValidateException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordReturnValidateException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
