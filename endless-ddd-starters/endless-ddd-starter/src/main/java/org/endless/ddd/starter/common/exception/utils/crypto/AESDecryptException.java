package org.endless.ddd.starter.common.exception.utils.crypto;

import org.endless.ddd.starter.common.exception.common.FailedException;
import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;

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
public class AESDecryptException extends FailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.UTL0142;

    public AESDecryptException() {
        super(ERROR_CODE);
    }

    public AESDecryptException(String message) {
        super(ERROR_CODE, message);
    }

    public AESDecryptException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public AESDecryptException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
