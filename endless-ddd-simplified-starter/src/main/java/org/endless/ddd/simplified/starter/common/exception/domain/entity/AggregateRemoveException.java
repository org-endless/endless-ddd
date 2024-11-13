package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * AggregateRemoveException
 * <p>
 * create 2024/10/12 10:11
 * <p>
 * update 2024/10/12 10:11
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class AggregateRemoveException extends AggregateException {

    private static final String DEFAULT_MESSAGE = "聚合根删除行为异常";

    public AggregateRemoveException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public AggregateRemoveException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public AggregateRemoveException(Throwable throwable) {
        super(throwable);
    }
}
