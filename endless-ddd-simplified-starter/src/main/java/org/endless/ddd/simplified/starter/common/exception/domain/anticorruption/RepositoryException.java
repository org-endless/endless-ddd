package org.endless.ddd.simplified.starter.common.exception.domain.anticorruption;

/**
 * RepositoryException
 * <p>
 * create 2024/09/29 11:29
 * <p>
 * update 2024/10/24 11:23
 *
 * @author lanruirui
 * @see RuntimeException
 * @since 2.0.0
 */
public class RepositoryException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "仓储异常";

    public RepositoryException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public RepositoryException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public RepositoryException(Throwable throwable) {
        super(throwable);
    }
}
