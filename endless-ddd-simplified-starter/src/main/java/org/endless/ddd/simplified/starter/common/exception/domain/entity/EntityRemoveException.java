package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * EntityRemoveException
 * <p>
 * create 2024/10/12 09:36
 * <p>
 * update 2024/10/12 09:36
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class EntityRemoveException extends EntityException {

    private static final String DEFAULT_MESSAGE = "实体删除行为异常";

    public EntityRemoveException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public EntityRemoveException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public EntityRemoveException(Throwable throwable) {
        super(throwable);
    }
}
