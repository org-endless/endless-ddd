package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * DataRecordAddItemException
 * <p>
 * create 2025/08/09 00:18
 * <p>
 * update 2025/08/09 00:18
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DataRecordAddItemException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDR0002;

    public DataRecordAddItemException() {
        super(ERROR_CODE);
    }

    public DataRecordAddItemException(String message) {
        super(ERROR_CODE, message);
    }

    public DataRecordAddItemException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DataRecordAddItemException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
