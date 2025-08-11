package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.filesystem;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

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

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DFS0002;

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
