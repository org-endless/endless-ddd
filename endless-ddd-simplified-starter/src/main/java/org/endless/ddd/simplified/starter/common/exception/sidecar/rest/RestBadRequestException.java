package org.endless.ddd.simplified.starter.common.exception.sidecar.rest;

/**
 * RestBadRequestException
 * <p>
 * create 2024/09/08 21:40
 * <p>
 * update 2024/09/08 21:41
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class RestBadRequestException extends RestException {

    private static final String DEFAULT_MESSAGE = "Rest请求无法处理";

    public RestBadRequestException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public RestBadRequestException(Throwable throwable) {
        super(throwable);
    }

    public RestBadRequestException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
