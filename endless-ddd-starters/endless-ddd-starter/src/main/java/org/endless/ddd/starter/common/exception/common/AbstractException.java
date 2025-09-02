package org.endless.ddd.starter.common.exception.common;

import lombok.Getter;
import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.utils.error.message.exception.ExceptionErrorParser;

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

    private final String method;

    private final transient ErrorCode errorCode;

    public AbstractException(ErrorCode errorCode) {
        super(ExceptionErrorParser.parse(null, errorCode, null));
        this.method = null;
        this.errorCode = errorCode;
    }

    public AbstractException(String method, ErrorCode errorCode) {
        super(ExceptionErrorParser.parse(method, errorCode, null));
        this.method = method;
        this.errorCode = errorCode;
    }

    public AbstractException(ErrorCode errorCode, String message) {
        super(ExceptionErrorParser.parse(null, errorCode, message));
        this.method = null;
        this.errorCode = errorCode;
    }

    public AbstractException(ErrorCode errorCode, Throwable throwable) {
        super(ExceptionErrorParser.parse(null, errorCode, null), throwable);
        this.method = null;
        this.errorCode = errorCode;
    }

    public AbstractException(String method, ErrorCode errorCode, String message) {
        super(ExceptionErrorParser.parse(method, errorCode, message));
        this.method = method;
        this.errorCode = errorCode;
    }

    public AbstractException(String method, ErrorCode errorCode, Throwable throwable) {
        super(ExceptionErrorParser.parse(method, errorCode, null), throwable);
        this.method = method;
        this.errorCode = errorCode;
    }

    public AbstractException(ErrorCode errorCode, String message, Throwable throwable) {
        super(ExceptionErrorParser.parse(null, errorCode, message), throwable);
        this.method = null;
        this.errorCode = errorCode;
    }

    public AbstractException(String method, ErrorCode errorCode, String message, Throwable throwable) {
        super(ExceptionErrorParser.parse(method, errorCode, message), throwable);
        this.method = method;
        this.errorCode = errorCode;
    }
}
