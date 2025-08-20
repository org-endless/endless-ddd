package org.endless.ddd.generator.components.generator.context.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorReqQueryTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ContextFindSimpleProfileRespQTransferReq
 * <p>限界上下文基本信息查询响应传输对象
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @param contextId 限界上下文ID
 * @param name      限界上下文名称
 * @author Deng Haozhi
 * @see DDDGeneratorReqQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"contextId", "name"})
public record ContextFindSimpleProfileRespQTransferReq(
        String contextId, String name) implements DDDGeneratorReqQueryTransfer {

    @Override
    public ContextFindSimpleProfileRespQTransferReq validate() {
        validateContextId();
        validateName();
        return this;
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new QueryReqTransferValidateException("限界上下文ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new QueryReqTransferValidateException("限界上下文名称不能为空");
        }
    }
}
