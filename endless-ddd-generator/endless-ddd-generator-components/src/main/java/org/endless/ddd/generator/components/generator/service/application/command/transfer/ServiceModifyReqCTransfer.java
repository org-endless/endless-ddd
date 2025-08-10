package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.ddd.starter.common.annotation.validate.number.port.Port;
import org.endless.ddd.starter.common.annotation.validate.string.cases.ArtifactId;
import org.endless.ddd.starter.common.annotation.validate.string.cases.PackageName;
import org.endless.ddd.starter.common.annotation.validate.string.cases.TransferPath;
import org.endless.ddd.starter.common.annotation.validate.string.cases.UpperCamelCase;

/**
 * ServiceModifyReqCTransfer
 * <p>服务修改命令请求传输对象
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
 * @param serviceId         服务ID
 * @param projectId         项目ID
 * @param serviceArtifactId 服务构件ID
 * @param name              服务名称
 * @param description       服务描述
 * @param author            服务作者
 * @param rootPath          服务根路径
 * @param basePackage       服务基础包名
 * @param classNamePrefix   服务类名前缀
 * @param type              服务类型
 * @param port              服务端口
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"serviceId", "projectId", "serviceArtifactId", "name",
        "description", "version", "author", "rootPath", "basePackage",
        "classNamePrefix", "type", "port"})
public record ServiceModifyReqCTransfer(
        @NotBlank(message = "服务ID不能为空") String serviceId,
        String projectId,
        @ArtifactId String serviceArtifactId,
        String name,
        String description,
        String author,
        @TransferPath String rootPath,
        @PackageName String basePackage,
        @UpperCamelCase String classNamePrefix,
        String type,
        @Port Integer port
) implements DDDGeneratorCommandTransfer {

    @Override
    public ServiceModifyReqCTransfer validate() {
        return this;
    }
}
