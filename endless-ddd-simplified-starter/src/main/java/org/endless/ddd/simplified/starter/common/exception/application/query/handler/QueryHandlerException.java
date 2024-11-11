package org.endless.ddd.simplified.starter.common.exception.application.query.handler;

/**
 * QueryHandlerException
 * <p>
 * create 2024/09/29 11:17
 * <p>
 * update 2024/09/29 11:17
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class QueryHandlerException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "查询处理器异常";

    public QueryHandlerException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public QueryHandlerException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public QueryHandlerException(Throwable throwable) {
        super(throwable);
    }
}
