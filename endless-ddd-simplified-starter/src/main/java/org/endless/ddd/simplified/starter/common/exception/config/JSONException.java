package org.endless.ddd.simplified.starter.common.exception.config;

/**
 * JsonException
 * <p>
 * create 2024/11/07 11:02
 * <p>
 * update 2024/11/07 11:02
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class JSONException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "JSON解析异常";

    public JSONException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public JSONException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public JSONException(Throwable throwable) {
        super(throwable);
    }
}
