package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class MapperException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库操作异常";

    public MapperException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MapperException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
