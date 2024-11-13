package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperModifyException
 * <p>
 * create 2024/09/29 15:58
 * <p>
 * update 2024/09/29 15:58
 *
 * @author Deng Haozhi
 * @see MapperException
 * @since 2.0.0
 */
public class MapperModifyException extends MapperException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库更新异常";

    public MapperModifyException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public MapperModifyException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperModifyException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
