package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;

/**
 * ServiceFindSimpleProfileRespQTransfer
 * <p>服务基本信息查询响应传输对象
 * <p>
 * create 2025/08/07 00:43
 * <p>
 * update 2025/08/07 00:43
 *
 * @param serviceId         服务ID
 * @param serviceArtifactId 服务构件ID
 * @param name              服务名称
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"serviceId", "serviceArtifactId", "name"})
public record ServiceFindSimpleProfileRespQTransfer(
        @NotNull(message = "服务ID不能为空") String serviceId,
        @NotNull(message = "服务构件ID不能为空") String serviceArtifactId,
        @NotNull(message = "服务名称不能为空") String name
) implements DDDGeneratorQueryTransfer {

    @Override
    public ServiceFindSimpleProfileRespQTransfer validate() {
        return this;
    }
}
