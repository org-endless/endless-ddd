package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

/**
 * FileSystemStoreException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/29 22:02
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class FileSystemStoreUnknownException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DFS9001");

    public FileSystemStoreUnknownException() {
        super(ERROR_CODE);
    }

    public FileSystemStoreUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemStoreUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemStoreUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);

    }
}
