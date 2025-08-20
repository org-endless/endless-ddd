package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * FileSystemRemoveFailedException
 * <p>
 * create 2024/11/28 22:31
 * <p>
 * update 2025/08/20 22:37
 *
 * @author Deng Haozhi
 * @see MinioFailedException
 * @since 1.0.0
 */
public class MinioRemoveFailedException extends MinioFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MIO0002");

    public MinioRemoveFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioRemoveFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioRemoveFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioRemoveFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioRemoveFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioRemoveFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
