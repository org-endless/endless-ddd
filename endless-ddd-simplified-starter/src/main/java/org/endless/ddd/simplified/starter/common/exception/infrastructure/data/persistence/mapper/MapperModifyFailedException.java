package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperModifyFailedException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2024/09/29 15:58
 *
 * @author Deng Haozhi
 * @see MapperException
 * @since 2.0.0
 */
public class MapperModifyFailedException extends MapperException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库更新失败";

    public MapperModifyFailedException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MapperModifyFailedException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperModifyFailedException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
