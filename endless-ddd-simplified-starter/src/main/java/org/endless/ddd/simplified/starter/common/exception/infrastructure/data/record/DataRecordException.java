package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.record;

/**
 * DataRecordException
 * <p>
 * create 2024/09/29 10:35
 * <p>
 * update 2024/09/29 10:36
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class DataRecordException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "数据库实体异常";

    public DataRecordException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public DataRecordException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public DataRecordException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
