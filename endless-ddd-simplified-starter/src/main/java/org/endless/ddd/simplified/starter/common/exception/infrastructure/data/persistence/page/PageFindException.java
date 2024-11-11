package org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.page;

/**
 * PageFindException
 * <p>
 * create 2024/09/12 12:19
 * <p>
 * update 2024/09/12 12:20
 *
 * @author Deng Haozhi
 * @see PageException
 * @since 2.0.0
 */
public class PageFindException extends PageException {

    private static final String DEFAULT_MESSAGE = "分页查询异常";

    public PageFindException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public PageFindException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public PageFindException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
