package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DataRecordNullException
 * <p>
 * create 2025/08/07 23:46
 * <p>
 * update 2025/08/07 23:56
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DataRecordNullException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDR0000");

    public DataRecordNullException() {
        super(ERROR_CODE);
    }

    public DataRecordNullException(String message) {
        super(ERROR_CODE, message);
    }

    public DataRecordNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DataRecordNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
