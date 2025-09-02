package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.exception.error.code.ErrorCode;

/**
 * FileSystemRetrieveException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2025/08/20 22:36
 *
 * @author Deng Haozhi
 * @see MinioUnknownException
 * @since 1.0.0
 */
public class MinioRetrieveUnknownException extends MinioUnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MIO9003;

    public MinioRetrieveUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioRetrieveUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioRetrieveUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioRetrieveUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioRetrieveUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioRetrieveUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }
}
