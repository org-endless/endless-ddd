package org.endless.ddd.simplified.starter.common.exception.domain.service;

/**
 * ServiceException
 * <p>
 * create 2024/09/29 11:33
 * <p>
 * update 2024/09/29 11:33
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class ServiceException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "领域服务异常";

    public ServiceException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }
}
