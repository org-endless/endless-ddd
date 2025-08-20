package org.endless.ddd.generator.components.generator.project.application.query.handler;

import org.endless.ddd.generator.common.model.application.query.handler.DDDGeneratorQueryHandler;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdReqQTransferReq;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransferReq;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindSimpleProfilesRespQTransferReq;

/**
 * ProjectQueryHandler
 * <p>项目领域查询处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorQueryHandler
 * @since 1.0.0
 */
public interface ProjectQueryHandler extends DDDGeneratorQueryHandler {

    ProjectFindSimpleProfilesRespQTransferReq findSimpleProfilesByIds(ProjectFindByIdsReqQTransferReq query);

    void existsById(ProjectFindByIdReqQTransferReq query);

}
