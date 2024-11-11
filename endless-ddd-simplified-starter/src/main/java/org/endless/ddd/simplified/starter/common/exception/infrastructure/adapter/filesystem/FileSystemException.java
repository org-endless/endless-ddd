package org.endless.ddd.simplified.starter.common.exception.infrastructure.adapter.filesystem;

/**
 * MapperException
 * <p>
 * create 2024/09/29 10:55
 * <p>
 * update 2024/09/29 11:08
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class FileSystemException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "文件系统异常";

    public FileSystemException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public FileSystemException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public FileSystemException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
