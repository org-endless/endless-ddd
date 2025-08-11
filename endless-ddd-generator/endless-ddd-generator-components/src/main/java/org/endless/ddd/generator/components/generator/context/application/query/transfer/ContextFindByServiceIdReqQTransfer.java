package org.endless.ddd.generator.components.generator.context.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ContextFindByServiceIdReqQTransfer
 * <p>限界上下文根据项目ID查询请求传输对象
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @param serviceId 限界上下文ID
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"serviceId"})
public record ContextFindByServiceIdReqQTransfer(String serviceId) implements DDDGeneratorQueryTransfer {

    @Override
    public ContextFindByServiceIdReqQTransfer validate() {
        validateServiceId();
        return this;
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new QueryReqTransferValidateException("限界上下文ID不能为空");
        }
    }
}
