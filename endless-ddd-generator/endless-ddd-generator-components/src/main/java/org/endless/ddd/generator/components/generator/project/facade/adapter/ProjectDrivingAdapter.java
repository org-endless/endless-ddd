package org.endless.ddd.generator.components.generator.project.facade.adapter;

import org.endless.ddd.generator.common.model.facade.adapter.DDDGeneratorDrivingAdapter;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindSimpleProfilesRespQTransfer;

/**
 * ProjectDrivingAdapter
 * <p>项目领域主动适配器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivingAdapter
 * @since 0.0.1
 */
public interface ProjectDrivingAdapter extends DDDGeneratorDrivingAdapter {

    void create(ProjectCreateReqCTransfer command);

    void remove(ProjectRemoveReqCTransfer command);

    void modify(ProjectModifyReqCTransfer command);

    void generate(ProjectGenerateReqCTransfer command);

    ProjectFindSimpleProfilesRespQTransfer findSimpleProfilesByIds(ProjectFindByIdsReqQTransfer query);
}
