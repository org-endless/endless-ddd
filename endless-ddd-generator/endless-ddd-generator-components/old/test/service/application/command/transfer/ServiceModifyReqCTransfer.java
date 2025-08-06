package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ServiceModifyReqCTransfer
 * <p>服务修改命令请求传输对象
 * <p>
 * create 2025/08/05 22:43
 * <p>
 * update 2025/08/05 22:43
 *
 * @param serviceId         服务ID
 * @param projectId         项目ID
 * @param serviceArtifactId 服务构件ID
 * @param groupId           服务组织ID
 * @param name              服务名称
 * @param description       服务描述
 * @param version           服务版本号
 * @param author            服务作者
 * @param rootPath          服务根路径
 * @param basePackage       服务基础包名
 * @param classNamePrefix   服务类名前缀
 * @param type              服务类型
 * @param port              服务端口
 * @param createAt          服务创建时间
 * @param modifyAt          服务更新时间
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"serviceId", "projectId", "serviceArtifactId", "groupId", "name", "description", "version", "author", "rootPath", "basePackage", "classNamePrefix", "type", "port", "createAt", "modifyAt"})
public record ServiceModifyReqCTransfer(
        String serviceId, String projectId, String serviceArtifactId, String groupId,
        String name, String description, String version, String author, String rootPath,
        String basePackage, String classNamePrefix, String type, Integer port)
        implements DDDGeneratorCommandTransfer {

    @Override
    public ServiceModifyReqCTransfer validate() {
        validateServiceId();
        return this;
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new CommandTransferValidateException("服务ID不能为空");
        }
    }
}
