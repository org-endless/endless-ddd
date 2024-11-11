package org.endless.ddd.simplified.starter.common.exception.application.command.transfer;

/**
 * CommandTransferException
 * <p>
 * create 2024/09/29 11:19
 * <p>
 * update 2024/09/29 11:19
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class CommandTransferException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "命令传输对象异常";

    public CommandTransferException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public CommandTransferException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public CommandTransferException(Throwable throwable) {
        super(throwable);
    }
}
