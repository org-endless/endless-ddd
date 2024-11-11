package com.tansun.atp.starter.common.exception.config;

/**
 * ThreadException
 * <p>
 * create 2024/11/10 15:19
 * <p>
 * update 2024/11/10 15:19
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class ThreadException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "线程异步处理异常";

    public ThreadException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public ThreadException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }

    public ThreadException(Throwable throwable) {
        super(throwable);
    }
}
