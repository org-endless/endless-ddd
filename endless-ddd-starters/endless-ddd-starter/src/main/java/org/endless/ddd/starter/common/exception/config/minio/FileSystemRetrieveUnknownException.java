package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * FileSystemRetrieveException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/29 21:59
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class FileSystemRetrieveUnknownException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DFS9003");

    public FileSystemRetrieveUnknownException() {
        super(ERROR_CODE);
    }

    public FileSystemRetrieveUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemRetrieveUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemRetrieveUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
