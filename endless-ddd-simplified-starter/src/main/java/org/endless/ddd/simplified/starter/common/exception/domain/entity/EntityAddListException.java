package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * EntityAddListException
 * <p>
 * create 2024/10/12 11:03
 * <p>
 * update 2024/10/12 11:03
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class EntityAddListException extends EntityException {

    private static final String DEFAULT_MESSAGE = "实体添加子实体列表行为异常";

    public EntityAddListException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public EntityAddListException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public EntityAddListException(Throwable throwable) {
        super(throwable);
    }
}
