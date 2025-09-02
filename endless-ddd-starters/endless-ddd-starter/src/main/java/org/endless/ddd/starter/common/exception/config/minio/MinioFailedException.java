package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * MinioFailedException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/07/29 22:00
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class MinioFailedException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MIO0000;

    public MinioFailedException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioFailedException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioFailedException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioFailedException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioFailedException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioFailedException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public MinioFailedException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
