package com.tansun.atp.starter.common.exception.application.command.handler;

/**
 * CommandHandlerRemoveException
 * <p>
 * create 2024/11/10 13:53
 * <p>
 * update 2024/11/10 13:53
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class CommandHandlerRemoveException extends CommandHandlerException {

    private static final String DEFAULT_MESSAGE = "命令处理器删除命令异常";

    public CommandHandlerRemoveException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public CommandHandlerRemoveException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public CommandHandlerRemoveException(Throwable throwable) {
        super(throwable);
    }
}
