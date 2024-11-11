package org.endless.domain.simplified.server.common.model.domain.event;

import org.endless.ddd.simplified.starter.common.model.domain.event.Event;
import org.endless.domain.simplified.server.common.model.domain.entity.DomainSimplifiedServerAggregate;

/**
 * DomainSimplifiedServerEvent
 * <p>
 * create 2024/09/06 15:14
 * <p>
 * update 2024/09/06 15:15
 *
 * @author Deng Haozhi
 * @see Event
 * @since 2.0.0
 */
public interface DomainSimplifiedServerEvent<A extends DomainSimplifiedServerAggregate>
        extends Event<A> {
}
