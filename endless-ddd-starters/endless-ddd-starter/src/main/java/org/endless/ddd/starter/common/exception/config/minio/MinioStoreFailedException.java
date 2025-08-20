package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * FileSystemStoreFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/20 22:37
 *
 * @author Deng Haozhi
 * @see MinioFailedException
 * @since 1.0.0
 */
public class MinioStoreFailedException extends MinioFailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MIO0001");

    public MinioStoreFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioStoreFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioStoreFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioStoreFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioStoreFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioStoreFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
