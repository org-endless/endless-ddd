package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;

/**
 * ServiceGenerateReqCTransfer
 * <p>服务生成命令请求传输对象
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
 * @param serviceId 服务ID
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"serviceId"})
public record ServiceGenerateReqCTransfer(
        @NotBlank(message = "服务ID不能为空") String serviceId
) implements DDDGeneratorCommandTransfer {

    @Override
    public ServiceGenerateReqCTransfer validate() {
        return this;
    }
}
