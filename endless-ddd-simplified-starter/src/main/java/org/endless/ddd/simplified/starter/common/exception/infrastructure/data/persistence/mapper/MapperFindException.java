package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperFindException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2024/09/29 15:58
 *
 * @author Deng Haozhi
 * @see MapperException
 * @since 2.0.0
 */
public class MapperFindException extends MapperException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库查询异常";

    public MapperFindException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MapperFindException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperFindException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
