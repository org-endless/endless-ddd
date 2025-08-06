package org.endless.ddd.starter.common.exception.utils.model;

import org.endless.ddd.starter.common.utils.model.string.StringTools;

/**
 * TimeStampException
 * <p>
 * create 2024/12/04 14:45
 * <p>
 * update 2024/12/04 14:45
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class TimeStampException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "时间戳工具处理异常";

    public TimeStampException(String message) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message));
    }

    public TimeStampException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message), throwable);
    }

    public TimeStampException(Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(throwable.getMessage()), throwable);
    }
}
