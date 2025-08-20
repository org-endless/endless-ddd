package org.endless.ddd.starter.common.exception.utils.model.object;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * ObjectToolsException
 * <p>
 * create 2024/11/19 10:25
 * <p>
 * update 2024/11/19 10:26
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class ObjectToolsException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL0032");

    public ObjectToolsException() {
        super(null, ERROR_CODE, null, null);
    }

    public ObjectToolsException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public ObjectToolsException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public ObjectToolsException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public ObjectToolsException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public ObjectToolsException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
