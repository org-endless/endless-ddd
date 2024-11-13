package org.endless.ddd.simplified.starter.common.exception.domain.entity;

/**
 * EntityException
 * <p>
 * create 2024/09/29 11:29
 * <p>
 * update 2024/09/29 11:29
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class EntityException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "实体类异常";

    public EntityException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public EntityException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public EntityException(Throwable throwable) {
        super(throwable);
    }
}
