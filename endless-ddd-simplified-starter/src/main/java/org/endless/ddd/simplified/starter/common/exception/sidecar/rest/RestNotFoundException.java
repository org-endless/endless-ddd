package org.endless.ddd.simplified.starter.common.exception.sidecar.rest;

/**
 * RestNotFoundException
 * <p>
 * create 2024/09/08 21:47
 * <p>
 * update 2024/09/08 21:48
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class RestNotFoundException extends RestException {

    private static final String DEFAULT_MESSAGE = "Rest请求的资源不存在";

    public RestNotFoundException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public RestNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public RestNotFoundException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
