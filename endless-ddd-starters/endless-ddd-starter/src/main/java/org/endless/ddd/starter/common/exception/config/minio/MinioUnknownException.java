package org.endless.ddd.starter.common.exception.config.minio;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.UnknownException;

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
public class MinioUnknownException extends UnknownException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("MIO9000");

    public MinioUnknownException() {
        super(null, ERROR_CODE, null, null);
    }

    public MinioUnknownException(String message) {
        super(null, ERROR_CODE, message, null);
    }

    public MinioUnknownException(Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
    }

    public MinioUnknownException(String method, String message) {
        super(method, ERROR_CODE, message, null);
    }

    public MinioUnknownException(String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
    }

    public MinioUnknownException(String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
    }

    public MinioUnknownException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(method, errorCode, message, throwable);
    }
}
