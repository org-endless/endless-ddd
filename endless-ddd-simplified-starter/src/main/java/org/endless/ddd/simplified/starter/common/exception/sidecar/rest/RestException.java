package org.endless.ddd.simplified.starter.common.exception.sidecar.rest;

/**
 * RestException
 * <p>
 * create 2024/09/08 19:38
 * <p>
 * update 2024/09/08 19:41
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class RestException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Rest请求异常";

    public RestException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public RestException(Throwable throwable) {
        super(throwable);
    }

    public RestException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
