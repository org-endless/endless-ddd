package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperRemoveFieldException
 * <p>
 * create 2024/11/06 09:37
 * <p>
 * update 2024/11/06 09:37
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class MapperRemoveFailedException extends MapperRemoveException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库删除失败";

    public MapperRemoveFailedException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MapperRemoveFailedException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperRemoveFailedException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
