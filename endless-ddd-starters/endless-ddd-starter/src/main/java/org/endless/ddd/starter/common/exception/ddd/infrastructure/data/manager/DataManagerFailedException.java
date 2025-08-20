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
public class DataManagerFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDM0000");

    public DataManagerFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public DataManagerFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
