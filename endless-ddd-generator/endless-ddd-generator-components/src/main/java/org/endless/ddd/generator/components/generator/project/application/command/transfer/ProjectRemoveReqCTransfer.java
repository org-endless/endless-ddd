package org.endless.ddd.generator.components.generator.project.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ProjectRemoveReqCTransfer
 * <p>项目删除命令请求传输对象
 * <p>
 * create 2025/08/05 22:07
 * <p>
 * update 2025/08/05 22:07
 *
 * @param projectId 项目ID
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"projectId"})
public record ProjectRemoveReqCTransfer(String projectId) implements DDDGeneratorCommandTransfer {

    @Override
    public ProjectRemoveReqCTransfer validate() {
        validateProjectId();
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new CommandTransferValidateException("项目ID不能为空");
        }
    }
}
