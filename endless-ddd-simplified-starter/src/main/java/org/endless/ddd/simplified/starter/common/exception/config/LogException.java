package org.endless.ddd.simplified.starter.common.exception.config;

/**
 * LogException
 * <p>
 * create 2024/11/13 09:19
 * <p>
 * update 2024/11/13 09:19
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class LogException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "日志处理异常";

    public LogException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public LogException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public LogException(Throwable throwable) {
        super(throwable);
    }
}
