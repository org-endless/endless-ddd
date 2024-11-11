package org.endless.ddd.simplified.starter.common.exception.domain.event;

/**
 * EventException
 * <p>
 * create 2024/09/29 11:32
 * <p>
 * update 2024/09/29 11:32
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class EventException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "领域事件异常";

    public EventException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public EventException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public EventException(Throwable throwable) {
        super(throwable);
    }
}
