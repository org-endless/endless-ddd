package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;

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
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"simpleProfiles"})
public record ServiceFindSimpleProfilesRespQTransfer(
        @NotEmpty(message = "服务基本信息列表不能为空")
        List<@Valid ServiceFindSimpleProfileRespQTransfer> simpleProfiles
) implements DDDGeneratorQueryTransfer {

    @Override
    public ServiceFindSimpleProfilesRespQTransfer validate() {
        return this;
    }
}
