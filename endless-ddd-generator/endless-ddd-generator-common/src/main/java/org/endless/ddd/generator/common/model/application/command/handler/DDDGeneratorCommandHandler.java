package org.endless.ddd.generator.common.model.application.command.handler;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.starter.common.ddd.application.command.handler.CommandHandler;

/**
 * DDDGeneratorCommandHandler
 * <p>
 * create 2024/08/30 17:19
 * <p>
 * update 2024/08/30 17:20
 *
 * @author Deng Haozhi
 * @see CommandHandler
 * @since 1.0.0
 */
public interface DDDGeneratorCommandHandler<A extends DDDGeneratorAggregate>
        extends CommandHandler<A> {

    String DDD_SIMPLIFIED_GENERATOR_USER_ID = "DDD_SIMPLIFIED_GENERATOR_USER_ID";
}
