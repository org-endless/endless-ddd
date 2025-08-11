package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * FileSystemRemoveFailedException
 * <p>
 * create 2024/11/28 22:31
 * <p>
 * update 2025/07/29 22:00
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class FileSystemRemoveFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DFS0002");

    public FileSystemRemoveFailedException() {
        super(ERROR_CODE);
    }

    public FileSystemRemoveFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemRemoveFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemRemoveFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
