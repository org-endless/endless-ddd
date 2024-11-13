package org.endless.ddd.simplified.starter.common.exception.application.command.handler;

/**
 * CommandHandlerException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/09/29 11:14
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class CommandHandlerException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "命令处理器异常";

    public CommandHandlerException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public CommandHandlerException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public CommandHandlerException(Throwable throwable) {
        super(throwable);
    }
}
