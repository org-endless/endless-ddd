package org.endless.ddd.starter.common.exception.security.password;

import lombok.Getter;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * InitialPasswordException
 * <p>
 * create 2024/12/05 17:58
 * <p>
 * update 2025/08/21 03:53
 *
 * @author Deng Haozhi
 * @see PasswordException
 * @since 1.0.0
 */
@Getter
public class InitialPasswordException extends PasswordException {

    private static final ErrorCode ERROR_CODE = ErrorCode.of("SEC0024");

    private final String userId;

    public InitialPasswordException(String userId) {
        super(null, ERROR_CODE, null, null);
        this.userId = userId;
    }

    public InitialPasswordException(String userId, String message) {
        super(null, ERROR_CODE, message, null);
        this.userId = userId;
    }

    public InitialPasswordException(String userId, Throwable throwable) {
        super(null, ERROR_CODE, null, throwable);
        this.userId = userId;
    }

    public InitialPasswordException(String userId, String method, String message) {
        super(method, ERROR_CODE, message, null);
        this.userId = userId;
    }

    public InitialPasswordException(String userId, String message, Throwable throwable) {
        super(null, ERROR_CODE, message, throwable);
        this.userId = userId;
    }

    public InitialPasswordException(String userId, String method, String message, Throwable throwable) {
        super(method, ERROR_CODE, message, throwable);
        this.userId = userId;
    }
}
