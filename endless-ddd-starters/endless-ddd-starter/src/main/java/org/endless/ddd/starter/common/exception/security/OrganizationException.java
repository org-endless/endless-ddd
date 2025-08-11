package org.endless.ddd.starter.common.exception.security;

import org.endless.ddd.starter.common.config.errorcode.type.ErrorCommonCode;
import org.endless.ddd.starter.common.exception.security.common.SecurityFailedException;

/**
 * OrganizationException
 * <p>
 * create 2025/01/22 18:27
 * <p>
 * update 2025/01/22 18:27
 *
 * @author Deng Haozhi
 * @see SecurityFailedException
 * @since 1.0.0
 */
public class OrganizationException extends SecurityFailedException {

    private static final ErrorCommonCode ERROR_CODE = ErrorCommonCode.SEC0050;

    public OrganizationException() {
        super(ERROR_CODE);
    }

    public OrganizationException(String message) {
        super(ERROR_CODE, message);
    }

    public OrganizationException(Throwable throwable) {
        super(ERROR_CODE, throwable);
    }

    public OrganizationException(String message, Throwable throwable) {
        super(ERROR_CODE, message, throwable);
    }
}
