package org.endless.ddd.simplified.starter.common.exception.config;

/**
 * MinioException
 * <p>
 * create 2024/11/07 12:07
 * <p>
 * update 2024/11/07 12:07
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class MinioException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Minio异常";

    public MinioException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MinioException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public MinioException(Throwable throwable) {
        super(throwable);
    }
}
