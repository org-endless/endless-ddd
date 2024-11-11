package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper;

/**
 * MapperUpsertException
 * <p>
 * create 2024/09/29 16:01
 * <p>
 * update 2024/09/29 16:02
 *
 * @author Deng Haozhi
 * @see MapperException
 * @since 2.0.0
 */
public class MapperUpsertException extends MapperException {

    private static final String DEFAULT_MESSAGE = "MyBatis数据库新增或更新异常";

    public MapperUpsertException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public MapperUpsertException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public MapperUpsertException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
