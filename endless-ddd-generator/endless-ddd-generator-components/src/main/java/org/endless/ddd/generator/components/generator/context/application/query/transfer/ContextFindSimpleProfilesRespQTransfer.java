package org.endless.ddd.generator.components.generator.context.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ContextFindSimpleProfilesRespQTransfer
 * <p>限界上下文基本信息列表查询响应传输对象
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @param simpleProfiles 限界上下文基本信息列表
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"simpleProfiles"})
public record ContextFindSimpleProfilesRespQTransfer(
        List<ContextFindSimpleProfileRespQTransfer> simpleProfiles) implements DDDGeneratorQueryTransfer {

    @Override
    public ContextFindSimpleProfilesRespQTransfer validate() {
        validateSimpleProfiles();
        return this;
    }

    private void validateSimpleProfiles() {
        if (!CollectionUtils.isEmpty(simpleProfiles)) {
            simpleProfiles.forEach(ContextFindSimpleProfileRespQTransfer::validate);
        }
    }
}
