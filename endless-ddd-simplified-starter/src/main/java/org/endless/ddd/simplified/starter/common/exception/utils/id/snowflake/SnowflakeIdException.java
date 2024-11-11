package org.endless.ddd.simplified.starter.common.exception.utils.id.snowflake;

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
public class SnowflakeIdException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "雪花ID生成异常";

    public SnowflakeIdException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public SnowflakeIdException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public SnowflakeIdException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
