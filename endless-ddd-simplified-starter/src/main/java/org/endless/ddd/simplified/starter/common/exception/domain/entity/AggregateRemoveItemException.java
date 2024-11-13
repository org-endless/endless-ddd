package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * AggregateRemoveItemException
 * <p>
 * create 2024/11/13 13:48
 * <p>
 * update 2024/11/13 13:49
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 2.0.0
 */
public class AggregateRemoveItemException extends AggregateException {

    private static final String DEFAULT_MESSAGE = "聚合根删除子实体行为异常";

    public AggregateRemoveItemException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public AggregateRemoveItemException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public AggregateRemoveItemException(Throwable throwable) {
        super(throwable);
    }
}
