package org.endless.ddd.simplified.starter.common.exception.validate;

/**
 * MapperException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class ValidateException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "数据校验异常";

    public ValidateException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public ValidateException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public ValidateException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
