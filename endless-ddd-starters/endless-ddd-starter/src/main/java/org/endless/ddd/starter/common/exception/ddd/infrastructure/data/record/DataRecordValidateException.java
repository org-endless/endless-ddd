package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * DataRecordValidateException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/07 23:46
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class DataRecordValidateException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DDR0001;

    public DataRecordValidateException() {
        super(ERROR_CODE);
    }

    public DataRecordValidateException(String message) {
        super(ERROR_CODE, message);
    }

    public DataRecordValidateException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DataRecordValidateException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
