package org.endless.domain.simplified.server.common.model.application.query.transfer;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.endless.ddd.simplified.starter.common.model.application.query.transfer.AbstractPageTransfer;

/**
 * DomainSimplifiedServerPageTransfer
 * <p>
 * create 2024/09/10 10:38
 * <p>
 * update 2024/09/10 13:35
 *
 * @author Deng Haozhi
 * @see AbstractPageTransfer
 * @since 1.0.0
 */
@Getter
@SuperBuilder
public class DomainSimplifiedServerPageTransfer extends AbstractPageTransfer {

    @Override
    public void validate() {
    }
}
