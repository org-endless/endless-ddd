package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DataRecordRemoveItemException
 * <p>
 * create 2025/08/21 01:28
 * <p>
 * update 2025/08/21 01:33
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordRemoveItemException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDR0202");

    public DataRecordRemoveItemException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordRemoveItemException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordRemoveItemException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordRemoveItemException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordRemoveItemException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordRemoveItemException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
