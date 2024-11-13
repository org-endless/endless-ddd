package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.record;

/**
 * DataRecordAddItemException
 * <p>
 * create 2024/10/29 14:58
 * <p>
 * update 2024/10/29 14:58
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class DataRecordAddItemException extends DataRecordException {

    private static final String DEFAULT_MESSAGE = "数据库实体增加子实体列表异常";

    public DataRecordAddItemException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public DataRecordAddItemException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DataRecordAddItemException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
