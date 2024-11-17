package org.endless.domain.simplified.server.common.exception.attchment;

/**
 * AttachmentCreationException
 * <p>
 * create 2024/09/14 09:09
 * <p>
 * update 2024/09/14 09:10
 *
 * @author Deng Haozhi
 * @see AttachmentException
 * @since 1.0.0
 */
public class AttachmentCreationException extends AttachmentException {

    public AttachmentCreationException(String message) {
        super(message);
    }

    public AttachmentCreationException(Throwable throwable) {
        super(throwable);
    }

    public AttachmentCreationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
