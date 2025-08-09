package org.endless.ddd.generator.components.generator.context.application.query.handler;

import org.endless.ddd.generator.common.model.application.query.handler.DDDGeneratorQueryHandler;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindByServiceIdReqQTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfilesRespQTransfer;

/**
 * ContextQueryHandler
 * <p>限界上下文领域查询处理器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see DDDGeneratorQueryHandler
 * @since 1.0.0
 */
public interface ContextQueryHandler extends DDDGeneratorQueryHandler {

    ContextFindSimpleProfilesRespQTransfer findSimpleProfilesByServiceId(ContextFindByServiceIdReqQTransfer query);

}
