package org.endless.ddd.simplified.starter.common.exception.application.command.handler;

/**
 * CommandHandlerModifyException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/09/29 11:14
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class CommandHandlerModifyException extends CommandHandlerException {

    private static final String DEFAULT_MESSAGE = "命令处理器修改命令异常";

    public CommandHandlerModifyException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public CommandHandlerModifyException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public CommandHandlerModifyException(Throwable throwable) {
        super(throwable);
    }
}
