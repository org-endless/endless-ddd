package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.filesystem;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * FileSystemRemoveException
 * <p>
 * create 2024/11/28 22:30
 * <p>
 * update 2025/07/29 21:57
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class FileSystemRemoveUnknownException extends UnknownException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DFS9002;

    public FileSystemRemoveUnknownException() {
        super(ERROR_CODE);
    }

    public FileSystemRemoveUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemRemoveUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemRemoveUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
