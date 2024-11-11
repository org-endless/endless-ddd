package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.record;

/**
 * DataRecordRemoveException
 * <p>
 * create 2024/09/29 11:36
 * <p>
 * update 2024/09/29 11:36
 * update 2024/09/29 11:36
 *
 * @author Deng Haozhi
 * @see DataRecordException
 * @since 2.0.0
 */
public class DataRecordRemoveException extends DataRecordException {

    private static final String DEFAULT_MESSAGE = "删除数据库实体异常";

    public DataRecordRemoveException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public DataRecordRemoveException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DataRecordRemoveException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
