package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * DataManagerFindFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/11/17 16:20
 *
 * @author Deng Haozhi
 * @see DataManagerFailedException
 * @since 1.0.0
 */
public class DataManagerFindFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDM0010");

    public DataManagerFindFailedException() {
        super(ERROR_CODE);
    }

    public DataManagerFindFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public DataManagerFindFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public DataManagerFindFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
