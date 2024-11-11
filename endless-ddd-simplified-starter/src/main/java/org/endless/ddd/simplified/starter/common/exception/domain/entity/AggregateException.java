package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * AggregateException
 * <p>
 * create 2024/09/29 11:30
 * <p>
 * update 2024/09/29 11:30
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class AggregateException extends EntityException {

    private static final String DEFAULT_MESSAGE = "聚合根异常";

    public AggregateException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public AggregateException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public AggregateException(Throwable throwable) {
        super(throwable);
    }
}
