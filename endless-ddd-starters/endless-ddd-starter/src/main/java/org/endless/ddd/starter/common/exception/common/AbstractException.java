package org.endless.ddd.starter.common.exception.common;

import lombok.Getter;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;
import org.endless.ddd.starter.common.utils.model.string.StringTools;

/**
 * AbstractException
 * <p>
 * create 2024/12/05 01:29
 * <p>
 * update 2024/12/05 01:30
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
@Getter
public class AbstractException extends RuntimeException {

    private final ErrorCode errorCode;

    private String method;

    public AbstractException(ErrorCode errorCode) {
        super("[" + errorCode.getDescription() + "]");
        this.errorCode = errorCode;
    }

    public AbstractException(ErrorCode errorCode, String message) {
        super(StringTools.addBrackets(message));
        this.errorCode = errorCode;
    }

    public AbstractException(ErrorCode errorCode, Throwable throwable) {
        super(StringTools.addBrackets(throwable.getMessage()), throwable);
        this.errorCode = errorCode;
    }

    public AbstractException(ErrorCode errorCode, String message, Throwable throwable) {
        super(StringTools.addBrackets(message), throwable);
        this.errorCode = errorCode;
    }

    public AbstractException put(String method) {
        this.method = method;
        return this;
    }
}
