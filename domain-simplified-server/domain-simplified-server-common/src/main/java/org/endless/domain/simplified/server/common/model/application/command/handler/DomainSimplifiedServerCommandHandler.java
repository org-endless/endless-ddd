package org.endless.domain.simplified.server.common.model.application.command.handler;

import org.endless.ddd.simplified.starter.common.model.application.command.handler.CommandHandler;
import org.endless.domain.simplified.server.common.model.domain.entity.DomainSimplifiedServerAggregate;

/**
 * DomainSimplifiedServerCommandHandler
 * <p>
 * create 2024/08/30 17:19
 * <p>
 * update 2024/08/30 17:20
 *
 * @author Deng Haozhi
 * @see CommandHandler
 * @since 2.0.0
 */
public interface DomainSimplifiedServerCommandHandler<A extends DomainSimplifiedServerAggregate>
        extends CommandHandler<A> {

}
