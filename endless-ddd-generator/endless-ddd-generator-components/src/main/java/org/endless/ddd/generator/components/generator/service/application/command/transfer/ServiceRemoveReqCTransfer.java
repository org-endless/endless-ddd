package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ServiceRemoveReqCTransfer
 * <p>服务删除命令请求传输对象
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
 * @param serviceId 服务ID
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"serviceId"})
public record ServiceRemoveReqCTransfer(String serviceId) implements DDDGeneratorCommandTransfer {

    @Override
    public ServiceRemoveReqCTransfer validate() {
        validateServiceId();
        return this;
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new CommandTransferValidateException("服务ID不能为空");
        }
    }
}
