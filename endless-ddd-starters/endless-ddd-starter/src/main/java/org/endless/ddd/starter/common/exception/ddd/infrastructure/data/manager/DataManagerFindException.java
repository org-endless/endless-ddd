package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

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
public class DataManagerFindException extends DataManagerFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.DDM1000;

    public DataManagerFindException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerFindException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerFindException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerFindException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerFindException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerFindException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
