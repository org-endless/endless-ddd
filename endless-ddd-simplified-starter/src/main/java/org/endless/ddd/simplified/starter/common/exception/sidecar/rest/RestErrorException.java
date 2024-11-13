package org.endless.ddd.simplified.starter.common.exception.sidecar.rest;

/**
 * RestErrorException
 * <p>
 * create 2024/09/08 19:49
 * <p>
 * update 2024/09/08 19:52
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class RestErrorException extends RestException {

    private static final String DEFAULT_MESSAGE = "Rest请求失败";

    public RestErrorException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public RestErrorException(Throwable throwable) {
        super(throwable);
    }

    public RestErrorException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
