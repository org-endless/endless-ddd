package org.endless.ddd.simplified.starter.common.exception.infrastructure.adapter.manager;

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
public class DrivenAdapterManagerException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "被动适配管理器异常";

    public DrivenAdapterManagerException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public DrivenAdapterManagerException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DrivenAdapterManagerException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
