package org.endless.domain.simplified.server.common.exception.attchment;

/**
 * AttachmentNotFoundException
 * <p>
 * create 2024/09/13 17:48
 * <p>
 * update 2024/09/13 17:48
 *
 * @author Deng Haozhi
 * @see AttachmentException
 * @since 1.0.0
 */
public class AttachmentNotFoundException extends AttachmentException {

    public AttachmentNotFoundException(String message) {
        super(message);
    }

    public AttachmentNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public AttachmentNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
