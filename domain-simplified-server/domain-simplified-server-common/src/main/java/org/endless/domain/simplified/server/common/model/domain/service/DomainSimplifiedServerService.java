package org.endless.domain.simplified.server.common.model.domain.service;

import org.endless.ddd.simplified.starter.common.model.domain.service.Service;
import org.endless.domain.simplified.server.common.model.domain.entity.DomainSimplifiedServerAggregate;

/**
 * DomainSimplifiedServerService
 * <p>
 * create 2024/02/11 22:04
 * <p>
 * update 2024/08/30 09:08
 *
 * @author Deng Haozhi
 * @see Service
 * @since 2.0.0
 */
public interface DomainSimplifiedServerService<A extends DomainSimplifiedServerAggregate>
        extends Service<A> {
}
