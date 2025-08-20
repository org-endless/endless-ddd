package org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.NotFoundException;

/**
 * DataManagerFindFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/11/17 16:20
 *
 * @author Deng Haozhi
 * @see NotFoundException
 * @since 1.0.0
 */
public class DataManagerNotFoundException extends NotFoundException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DDM1001");

    public DataManagerNotFoundException() {
        super(null, ERROR_CODE, null, null);
    }

    public DataManagerNotFoundException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public DataManagerNotFoundException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public DataManagerNotFoundException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public DataManagerNotFoundException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public DataManagerNotFoundException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
