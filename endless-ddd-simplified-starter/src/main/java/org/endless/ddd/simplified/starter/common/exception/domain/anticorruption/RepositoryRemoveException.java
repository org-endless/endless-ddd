package org.endless.ddd.simplified.starter.common.exception.domain.anticorruption;

/**
 * RepositoryRemoveException
 * <p>
 * create 2024/09/29 11:29
 * <p>
 * update 2024/10/24 11:23
 * update 2024/10/24 11:24
 *
 * @author lanruirui
 * @see RepositoryException
 * @since 2.0.0
 */
public class RepositoryRemoveException extends RepositoryException {

    private static final String DEFAULT_MESSAGE = "仓储删除异常";

    public RepositoryRemoveException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public RepositoryRemoveException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public RepositoryRemoveException(Throwable throwable) {
        super(throwable);
    }
}
