package org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.manager;

import org.endless.ddd.starter.common.utils.model.string.StringTools;

/**
 * DrivenAdapterException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 1.0.0
 */
public class DrivenAdapterException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "被动适配管理器异常";

    public DrivenAdapterException(String message) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message));
    }

    public DrivenAdapterException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(message), throwable);
    }

    public DrivenAdapterException(Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]" + StringTools.addBrackets(throwable.getMessage()), throwable);
    }
}
