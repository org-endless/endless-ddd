package org.endless.ddd.simplified.starter.common.exception.application.query.repository;

/**
 * QueryRepositoryException
 * <p>
 * create 2024/10/28 09:03
 * <p>
 * update 2024/10/28 09:03
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class QueryRepositoryException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "查询仓储异常";

    public QueryRepositoryException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public QueryRepositoryException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public QueryRepositoryException(Throwable throwable) {
        super(throwable);
    }
}
