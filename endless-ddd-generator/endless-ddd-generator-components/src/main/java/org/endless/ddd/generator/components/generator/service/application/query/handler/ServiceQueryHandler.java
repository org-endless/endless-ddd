package org.endless.ddd.generator.components.generator.service.application.query.handler;

import org.endless.ddd.generator.common.model.application.query.handler.DDDGeneratorQueryHandler;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindByProjectIdReqQTransfer;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindSimpleProfilesRespQTransfer;

/**
 * ServiceQueryHandler
 * <p>
 * 服务领域查询处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorQueryHandler
 * @since 0.0.1
 */
public interface ServiceQueryHandler extends DDDGeneratorQueryHandler {

    ServiceFindSimpleProfilesRespQTransfer findSimpleProfilesByProjectId(ServiceFindByProjectIdReqQTransfer query);

}
