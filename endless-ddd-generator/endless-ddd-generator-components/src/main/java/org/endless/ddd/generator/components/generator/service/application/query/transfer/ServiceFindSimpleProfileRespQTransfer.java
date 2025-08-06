package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.exception.model.application.query.transfer.QueryTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ServiceFindSimpleProfileRespQTransfer
 * <p>服务基本信息查询响应传输对象
 * <p>
 * create 2025/08/07 00:10
 * <p>
 * update 2025/08/07 00:10
 *
 * @param serviceId 服务ID
 * @param name      服务名称
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"serviceId", "name"})
public record ServiceFindSimpleProfileRespQTransfer(
        String serviceId, String name)
        implements DDDGeneratorQueryTransfer {

    @Override
    public ServiceFindSimpleProfileRespQTransfer validate() {
        validateServiceId();
        validateName();
        return this;
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new QueryTransferValidateException("服务ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new QueryTransferValidateException("服务名称不能为空");
        }
    }
}
