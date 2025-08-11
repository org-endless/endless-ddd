package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DataManagerFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class DataManagerRequestNullException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDM0100");

    public DataManagerRequestNullException() {
        super(ERROR_CODE);
    }

    public DataManagerRequestNullException(String message) {
        super(ERROR_CODE, message);
    }

    public DataManagerRequestNullException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DataManagerRequestNullException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
