package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DataRecordException
 * <p>
 * create 2025/08/21 00:21
 * <p>
 * update 2025/08/21 01:23
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DataRecordException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDR0000;

    public DataRecordException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataRecordException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataRecordException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataRecordException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataRecordException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataRecordException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public DataRecordException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
