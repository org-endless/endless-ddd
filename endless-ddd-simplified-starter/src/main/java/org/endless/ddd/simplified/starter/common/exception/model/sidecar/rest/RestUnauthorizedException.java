package org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest;

import org.endless.ddd.simplified.starter.common.utils.string.StringTools;

/**
 * RestUnauthorizedException
 * <p>
 * create 2024/09/08 19:52
 * <p>
 * update 2024/11/17 16:25
 *
 * @author Deng Haozhi
 * @see RestException
 * @since 1.0.0
 */
public class RestUnauthorizedException extends RestException {

    private static final String DEFAULT_MESSAGE = "身份认证异常";

    public RestUnauthorizedException(String message) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message));
    }

    public RestUnauthorizedException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message), throwable);
    }

    public RestUnauthorizedException(Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(throwable.getMessage()), throwable);
    }
}
