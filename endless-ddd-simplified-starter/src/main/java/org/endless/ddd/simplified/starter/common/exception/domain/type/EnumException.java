package org.endless.ddd.simplified.starter.common.exception.domain.type;

/**
 * EnumException
 * <p>
 * create 2024/09/29 11:42
 * <p>
 * update 2024/09/29 11:42
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class EnumException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "枚举异常";

    public EnumException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public EnumException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public EnumException(Throwable throwable) {
        super(throwable);
    }
}
