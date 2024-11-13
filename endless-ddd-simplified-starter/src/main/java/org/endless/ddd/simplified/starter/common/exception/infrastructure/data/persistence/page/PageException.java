package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.page;

/**
 * PageException
 * <p>
 * create 2024/09/12 12:18
 * <p>
 * update 2024/09/12 12:18
 * update 2024/09/12 12:18
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class PageException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "分页异常";

    public PageException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public PageException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public PageException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
