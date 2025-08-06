package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ServiceFindSimpleProfilesRespQTransfer
 * <p>服务基本信息列表查询响应传输对象
 * <p>
 * create 2025/08/07 00:10
 * <p>
 * update 2025/08/07 00:10
 *
 * @param simpleProfiles 服务基本信息列表
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"simpleProfiles"})
public record ServiceFindSimpleProfilesRespQTransfer(
        List<ServiceFindSimpleProfileRespQTransfer> simpleProfiles) implements DDDGeneratorQueryTransfer {

    @Override
    public ServiceFindSimpleProfilesRespQTransfer validate() {
        validateSimpleProfiles();
        return this;
    }

    private void validateSimpleProfiles() {
        if (!CollectionUtils.isEmpty(simpleProfiles)) {
            simpleProfiles.forEach(ServiceFindSimpleProfileRespQTransfer::validate);
        }
    }
}
