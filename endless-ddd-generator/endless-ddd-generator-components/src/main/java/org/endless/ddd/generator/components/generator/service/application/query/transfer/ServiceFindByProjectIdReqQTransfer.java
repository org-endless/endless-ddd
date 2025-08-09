package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;

/**
 * ServiceFindByProjectIdReqQTransfer
 * <p>服务根据项目ID查询请求传输对象
 * <p>
 * create 2025/08/07 00:10
 * <p>
 * update 2025/08/07 00:10
 *
 * @param projectId 项目ID
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"projectId"})
public record ServiceFindByProjectIdReqQTransfer(
        @NotNull(message = "项目ID不能为空") String projectId
) implements DDDGeneratorQueryTransfer {

    @Override
    public ServiceFindByProjectIdReqQTransfer validate() {
        return this;
    }
}
