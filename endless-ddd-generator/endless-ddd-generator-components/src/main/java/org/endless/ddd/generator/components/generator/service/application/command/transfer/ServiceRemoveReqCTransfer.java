package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorReqCommandTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;

/**
 * ServiceRemoveReqCTransferReq
 * <p>服务删除命令请求传输对象
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
 * @param serviceId 服务ID
 * @author Deng Haozhi
 * @see DDDGeneratorReqCommandTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"serviceId"})
public record ServiceRemoveReqCTransfer(
        @NotBlank(message = "服务ID不能为空") String serviceId
) implements DDDGeneratorReqCommandTransfer {

    @Override
    public ServiceRemoveReqCTransfer validate() {
        return this;
    }
}
