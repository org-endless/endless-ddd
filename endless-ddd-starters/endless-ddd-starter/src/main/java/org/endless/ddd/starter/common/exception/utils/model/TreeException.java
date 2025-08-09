package org.endless.ddd.starter.common.exception.utils.model;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.exception.handler.type.ErrorCode;

/**
 * TreeException
 * <p>
 * create 2024/12/18 17:19
 * <p>
 * update 2024/12/18 17:26
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class TreeException extends FailedException {

    public TreeException() {
        super(ErrorCode.UTL0012);
    }

    public TreeException(String message) {
        super(ErrorCode.UTL0012, message);
    }

    public TreeException(Throwable throwable) {
        super(ErrorCode.UTL0012, throwable);
    }

    public TreeException(String message, Throwable throwable) {
        super(ErrorCode.UTL0012, message, throwable);
    }
}
