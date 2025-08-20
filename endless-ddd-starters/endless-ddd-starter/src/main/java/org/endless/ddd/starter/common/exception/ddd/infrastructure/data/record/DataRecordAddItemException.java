package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * DataRecordAddItemException
 * <p>
 * create 2025/08/09 00:18
 * <p>
 * update 2025/08/09 00:18
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordAddItemException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDR0200");

    public DataRecordAddItemException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordAddItemException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordAddItemException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordAddItemException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordAddItemException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordAddItemException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
