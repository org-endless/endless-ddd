package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.filesystem;

import org.endless.ddd.starter.common.exception.common.UnknownException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

/**
 * FileSystemException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/29 21:51
 *
 * @author Deng Haozhi
 * @see UnknownException
 * @since 1.0.0
 */
public class FileSystemUnknownException extends UnknownException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.DFS9000;

    public FileSystemUnknownException() {
        super(ERROR_CODE);
    }

    public FileSystemUnknownException(String message) {
        super(ERROR_CODE, message);
    }

    public FileSystemUnknownException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public FileSystemUnknownException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
