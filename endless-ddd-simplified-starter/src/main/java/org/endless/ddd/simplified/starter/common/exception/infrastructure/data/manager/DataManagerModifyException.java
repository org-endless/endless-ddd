package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.manager;

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
public class DataManagerModifyException extends DataManagerException {

    private static final String DEFAULT_MESSAGE = "数据管理器修改异常";

    public DataManagerModifyException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public DataManagerModifyException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DataManagerModifyException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
