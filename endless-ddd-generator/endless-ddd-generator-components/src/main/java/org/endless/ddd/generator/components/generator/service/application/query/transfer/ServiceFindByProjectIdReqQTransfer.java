package org.endless.ddd.generator.components.generator.service.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.exception.model.application.query.transfer.QueryTransferValidateException;
import org.springframework.util.StringUtils;

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
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"projectId"})
public record ServiceFindByProjectIdReqQTransfer(String projectId) implements DDDGeneratorQueryTransfer {

    @Override
    public ServiceFindByProjectIdReqQTransfer validate() {
        validateProjectId();
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new QueryTransferValidateException("项目ID不能为空");
        }
    }
}
