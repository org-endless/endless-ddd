package org.endless.ddd.starter.common.exception.ddd.application.command.handler;

import org.endless.ddd.starter.common.utils.model.string.StringTools;

/**
 * CommandHandlerException
 * <p>
 * create 2024/09/29 11:14
 * <p>
 * update 2024/11/17 16:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class CommandHandlerException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "命令处理器异常";

    public CommandHandlerException(String message) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message));
    }

    public CommandHandlerException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message), throwable);
    }

    public CommandHandlerException(Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(throwable.getMessage()), throwable);
    }
}
