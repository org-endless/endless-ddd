package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * FileSystemStoreFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/29 22:01
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class FileSystemStoreFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DFS0001");

    public FileSystemStoreFailedException() {
        super(ERROR_CODE);
    }

    public FileSystemStoreFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemStoreFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemStoreFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
