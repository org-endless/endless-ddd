package org.endless.ddd.simplified.starter.common.exception.facade.adapter;

/**
 * DrivingAdapterException
 * <p>
 * create 2024/09/29 11:35
 * <p>
 * update 2024/09/29 11:35
 *
 * @author lanruirui
 * @since 2.0.0
 */
public class DrivingAdapterException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "主动适配器异常";

    public DrivingAdapterException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public DrivingAdapterException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }

    public DrivingAdapterException(Throwable throwable) {
        super(throwable);
    }
}
