package org.endless.ddd.generator.common.model.domain.event;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.starter.common.model.domain.event.Event;

/**
 * DDDGeneratorEvent
 * <p>
 * create 2024/09/06 15:14
 * <p>
 * update 2024/09/06 15:15
 *
 * @author Deng Haozhi
 * @see Event
 * @since 1.0.0
 */
public interface DDDGeneratorEvent<A extends DDDGeneratorAggregate>
        extends Event<A> {

}
