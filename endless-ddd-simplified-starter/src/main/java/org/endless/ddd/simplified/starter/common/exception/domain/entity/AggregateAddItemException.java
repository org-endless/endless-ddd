package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * AggregateAddItemException
 * <p>
 * create 2024/10/12 11:02
 * <p>
 * update 2024/11/13 13:49
 *
 * @author Deng Haozhi
 * @see AggregateException
 * @since 2.0.0
 */
public class AggregateAddItemException extends AggregateException {

    private static final String DEFAULT_MESSAGE = "聚合根添加子实体行为异常";

    public AggregateAddItemException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public AggregateAddItemException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public AggregateAddItemException(Throwable throwable) {
        super(throwable);
    }
}
