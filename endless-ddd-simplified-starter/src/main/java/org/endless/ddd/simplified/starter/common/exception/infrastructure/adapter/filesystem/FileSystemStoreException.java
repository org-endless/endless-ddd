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
public class FileSystemStoreException extends FileSystemException {

    private static final String DEFAULT_MESSAGE = "文件系统存储异常";

    public FileSystemStoreException(String message) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message);
    }

    public FileSystemStoreException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public FileSystemStoreException(String message, Throwable throwable) {
        super(message == null ? DEFAULT_MESSAGE + "：" : message, throwable);
    }
}
