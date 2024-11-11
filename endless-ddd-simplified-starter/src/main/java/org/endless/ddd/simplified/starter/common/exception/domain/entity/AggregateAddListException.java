package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * AggregateAddListException
 * <p>
 * create 2024/10/12 11:02
 * <p>
 * update 2024/10/12 11:02
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class AggregateAddListException extends AggregateException {

    private static final String DEFAULT_MESSAGE = "聚合根添加子实体列表行为异常";

    public AggregateAddListException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public AggregateAddListException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public AggregateAddListException(Throwable throwable) {
        super(throwable);
    }
}
