package org.endless.domain.simplified.server.common.exception.attchment;

/**
 * AttachmentException
 * <p>
 * create 2024/09/13 17:46
 * <p>
 * update 2024/09/13 17:47
 *
 * @author Deng Haozhi
 * @see RuntimeException
 * @since 2.0.0
 */
public class AttachmentException extends RuntimeException{

    public AttachmentException(String message) {
        super(message);
    }

    public AttachmentException(Throwable throwable) {
        super(throwable);
    }

    public AttachmentException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
