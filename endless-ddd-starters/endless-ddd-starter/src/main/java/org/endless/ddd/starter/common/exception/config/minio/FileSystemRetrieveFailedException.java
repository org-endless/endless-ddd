package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * FileSystemRetrieveFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/29 22:00
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class FileSystemRetrieveFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("DFS0003");

    public FileSystemRetrieveFailedException() {
        super(ERROR_CODE);
    }

    public FileSystemRetrieveFailedException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemRetrieveFailedException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemRetrieveFailedException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
