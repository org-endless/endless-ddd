package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorReqQueryTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;

/**
 * ServiceFindByProjectIdReqQTransferReq
 * <p>服务根据项目ID查询请求传输对象
 * <p>
 * create 2025/08/07 00:10
 * <p>
 * update 2025/08/07 00:10
 *
 * @param projectId 项目ID
 * @author Deng Haozhi
 * @see DDDGeneratorReqQueryTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"projectId"})
public record ServiceFindByProjectIdReqQTransferReq(
        @NotNull(message = "项目ID不能为空") String projectId
) implements DDDGeneratorReqQueryTransfer {

    @Override
    public ServiceFindByProjectIdReqQTransferReq validate() {
        return this;
    }
}
