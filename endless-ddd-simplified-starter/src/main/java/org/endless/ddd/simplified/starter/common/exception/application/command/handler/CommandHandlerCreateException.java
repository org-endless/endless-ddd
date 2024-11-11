package org.endless.ddd.simplified.starter.common.exception.application.command.handler;

/**
 * CommandHandlerCreateException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/09/29 11:14
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class CommandHandlerCreateException extends CommandHandlerException {

    private static final String DEFAULT_MESSAGE = "创建命令异常";

    public CommandHandlerCreateException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public CommandHandlerCreateException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public CommandHandlerCreateException(Throwable throwable) {
        super(throwable);
    }
}
