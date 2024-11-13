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
public class FileSystemRetrieveException extends FileSystemException {

    private static final String DEFAULT_MESSAGE = "文件系统取回异常";

    public FileSystemRetrieveException(String message) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">");
    }

    public FileSystemRetrieveException(Throwable throwable) {
        super(DEFAULT_MESSAGE, throwable);
    }

    public FileSystemRetrieveException(String message, Throwable throwable) {
        super("[" + DEFAULT_MESSAGE + "]<" + message + ">", throwable);
    }
}
