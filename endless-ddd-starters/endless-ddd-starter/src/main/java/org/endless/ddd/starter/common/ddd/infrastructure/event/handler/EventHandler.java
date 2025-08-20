package org.endless.ddd.starter.common.ddd.infrastructure.event.handler;

import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.ddd.domain.event.Event;

/**
 * EventHandler
 * <p>
 * create 2025/08/11 18:25
 * <p>
 * update 2025/08/11 18:25
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface EventHandler<E extends Event<? extends Aggregate>> {

}
