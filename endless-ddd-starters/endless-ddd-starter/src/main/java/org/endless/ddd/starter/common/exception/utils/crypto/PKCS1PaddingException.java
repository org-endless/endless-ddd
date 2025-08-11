package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.exception.common.FailedException;

/**
 * SM2DecryptException
 * <p>
 * create 2024/11/16 04:04
 * <p>
 * update 2024/11/16 23:54
 *
 * @author Deng Haozhi
 * @see FailedException
 * @since 1.0.0
 */
public class PKCS1PaddingException extends FailedException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("UTL8000");

    public PKCS1PaddingException() {
        super(ERROR_CODE);
    }

    public PKCS1PaddingException(String message) {
        super(ERROR_CODE, message);
    }

    public PKCS1PaddingException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public PKCS1PaddingException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
