package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.record;

/**
 * DataRecordAddListException
 * <p>
 * create 2024/10/29 14:58
 * <p>
 * update 2024/10/29 14:58
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class DataRecordAddListException extends DataRecordException {

    private static final String DEFAULT_MESSAGE = "数据库实体增加子实体列表异常";

    public DataRecordAddListException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public DataRecordAddListException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DataRecordAddListException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
