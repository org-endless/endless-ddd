package org.endless.ddd.generator.components.generator.project.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ProjectFindSimpleProfilesRespQTransfer
 * <p>项目基本信息列表查询响应传输对象
 * <p>
 * create 2025/08/06 23:20
 * <p>
 * update 2025/08/06 23:20
 *
 * @param simpleProfiles 项目基本信息列表
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"simpleProfiles"})
public record ProjectFindSimpleProfilesRespQTransfer(
        List<ProjectFindSimpleProfileRespQTransfer> simpleProfiles) implements DDDGeneratorQueryTransfer {

    @Override
    public ProjectFindSimpleProfilesRespQTransfer validate() {
        validateSimpleProfiles();
        return this;
    }

    private void validateSimpleProfiles() {
        if (!CollectionUtils.isEmpty(simpleProfiles)) {
            simpleProfiles.forEach(ProjectFindSimpleProfileRespQTransfer::validate);
        }
    }
}
