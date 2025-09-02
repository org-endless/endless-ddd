package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * FileSystemRemoveException
 * <p>
 * create 2024/11/28 22:30
 * <p>
 * update 2025/08/20 22:37
 *
 * @author Deng Haozhi
 * @see MinioUnknownException
 * @since 1.0.0
 */
public class MinioRemoveUnknownException extends MinioUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MIO9002;

    public MinioRemoveUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioRemoveUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioRemoveUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioRemoveUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioRemoveUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioRemoveUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
