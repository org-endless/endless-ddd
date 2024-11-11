package org.endless.ddd.simplified.starter.common.exception.domain.value;

/**
 * ValueException
 * <p>
 * create 2024/09/29 11:33
 * <p>
 * update 2024/09/29 11:33
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class ValueException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "值对象异常";

    public ValueException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public ValueException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public ValueException(Throwable cause) {
        super(cause);
    }
}
