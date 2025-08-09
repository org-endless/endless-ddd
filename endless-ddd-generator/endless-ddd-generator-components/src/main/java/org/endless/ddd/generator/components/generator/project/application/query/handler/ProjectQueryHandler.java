package org.endless.ddd.generator.components.generator.project.application.query.handler;

import org.endless.ddd.generator.common.model.application.query.handler.DDDGeneratorQueryHandler;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdReqQTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindSimpleProfilesRespQTransfer;

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

    ProjectFindSimpleProfilesRespQTransfer findSimpleProfilesByIds(ProjectFindByIdsReqQTransfer query);

    void existsById(ProjectFindByIdReqQTransfer query);

}
