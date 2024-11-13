package org.endless.ddd.simplified.starter.common.exception.sidecar.rest;

/**
 * RestUnauthorizedException
 * <p>
 * create 2024/09/08 19:52
 * <p>
 * update 2024/09/08 19:53
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class RestUnauthorizedException extends RestException {

    private static final String DEFAULT_MESSAGE = "Rest请求未授权访问";

    public RestUnauthorizedException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public RestUnauthorizedException(Throwable throwable) {
        super(throwable);
    }

    public RestUnauthorizedException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
