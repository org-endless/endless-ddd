package org.endless.ddd.generator.components.generator.project.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorReqQueryTransfer;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ProjectFindSimpleProfilesRespQTransferReq
 * <p>项目基本信息列表查询响应传输对象
 * <p>
 * create 2025/08/06 23:20
 * <p>
 * update 2025/08/06 23:20
 *
 * @param simpleProfiles 项目基本信息列表
 * @author Deng Haozhi
 * @see DDDGeneratorReqQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"simpleProfiles"})
public record ProjectFindSimpleProfilesRespQTransferReq(
        List<ProjectFindSimpleProfileRespQTransferReq> simpleProfiles) implements DDDGeneratorReqQueryTransfer {

    @Override
    public ProjectFindSimpleProfilesRespQTransferReq validate() {
        validateSimpleProfiles();
        return this;
    }

    private void validateSimpleProfiles() {
        if (!CollectionUtils.isEmpty(simpleProfiles)) {
            simpleProfiles.forEach(ProjectFindSimpleProfileRespQTransferReq::validate);
        }
    }
}
