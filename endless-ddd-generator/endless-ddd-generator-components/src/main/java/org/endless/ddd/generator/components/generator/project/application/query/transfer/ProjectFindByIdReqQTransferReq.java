package org.endless.ddd.generator.components.generator.project.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorReqQueryTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ProjectFindByIdReqQTransferReq
 * <p>项目根据ID查询请求传输对象
 * <p>
 * create 2025/08/07 08:40
 * <p>
 * update 2025/08/07 08:40
 *
 * @param projectId 项目ID
 * @author Deng Haozhi
 * @see DDDGeneratorReqQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"projectId"})
public record ProjectFindByIdReqQTransferReq(String projectId) implements DDDGeneratorReqQueryTransfer {

    @Override
    public ProjectFindByIdReqQTransferReq validate() {
        validateProjectId();
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new QueryReqTransferValidateException("项目ID不能为空");
        }
    }
}
