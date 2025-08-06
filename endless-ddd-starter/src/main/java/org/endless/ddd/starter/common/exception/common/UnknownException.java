package org.endless.ddd.starter.common.exception.common;

import org.endless.ddd.starter.common.handler.result.type.ErrorCode;

/**
 * UnknownException
 * <p>
 * create 2024/12/05 02:05
 * <p>
 * update 2024/12/05 02:07
 * update 2025/07/19 02:56
 *
 * @author Deng Haozhi
 * @see AbstractException
 * @since 1.0.0
 */
public class UnknownException extends AbstractException {

    public UnknownException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UnknownException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public UnknownException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public UnknownException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
