package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * DataRecordAddItemsException
 * <p>
 * create 2025/08/21 01:28
 * <p>
 * update 2025/08/21 01:31
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 1.0.0
 */
public class DataRecordAddItemsException extends DataRecordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDR0201;

    public DataRecordAddItemsException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordAddItemsException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordAddItemsException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordAddItemsException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordAddItemsException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordAddItemsException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
