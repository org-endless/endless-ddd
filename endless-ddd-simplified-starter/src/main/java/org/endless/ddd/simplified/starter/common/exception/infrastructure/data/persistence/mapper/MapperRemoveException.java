package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperRemoveException
 * <p>
 * create 2024/09/29 16:04
 * <p>
 * update 2024/09/29 16:04
 *
 * @author Deng Haozhi
 * @see MapperException
 * @since 2.0.0
 */
public class MapperRemoveException extends MapperException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库删除异常";

    public MapperRemoveException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MapperRemoveException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperRemoveException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
