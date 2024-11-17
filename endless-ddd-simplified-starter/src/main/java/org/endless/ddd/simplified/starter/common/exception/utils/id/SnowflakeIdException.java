package org.endless.ddd.simplified.starter.common.exception.utils.id;

import org.endless.ddd.simplified.starter.common.utils.string.StringTools;

/**
 * MapperException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class SnowflakeIdException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "雪花ID生成异常";

    public SnowflakeIdException(String message) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message));
    }

    public SnowflakeIdException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message), throwable);
    }

    public SnowflakeIdException(Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(throwable.getMessage()), throwable);
    }
}
