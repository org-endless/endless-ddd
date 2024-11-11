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
public class DataManagerRemoveException extends DataManagerException {

    private static final String DEFAULT_MESSAGE = "数据管理器删除异常";

    public DataManagerRemoveException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public DataManagerRemoveException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DataManagerRemoveException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
