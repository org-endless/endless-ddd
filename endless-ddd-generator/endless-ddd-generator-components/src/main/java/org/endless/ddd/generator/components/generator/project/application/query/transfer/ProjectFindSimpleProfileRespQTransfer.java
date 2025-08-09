package org.endless.ddd.generator.components.generator.project.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ProjectFindSimpleProfileRespQTransfer
 * <p>项目基本信息查询响应传输对象
 * <p>
 * create 2025/08/06 23:20
 * <p>
 * update 2025/08/06 23:20
 *
 * @param projectId 项目ID
 * @param name      项目名称
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"projectId", "name"})
public record ProjectFindSimpleProfileRespQTransfer(
        String projectId, String name) implements DDDGeneratorQueryTransfer {

    @Override
    public ProjectFindSimpleProfileRespQTransfer validate() {
        validateProjectId();
        validateName();
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new QueryTransferValidateException("项目ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new QueryTransferValidateException("项目名称不能为空");
        }
    }
}
