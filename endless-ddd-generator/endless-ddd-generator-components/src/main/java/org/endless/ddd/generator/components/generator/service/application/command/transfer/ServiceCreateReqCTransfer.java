package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.ddd.starter.common.annotation.validate.number.port.Port;

/**
 * ServiceCreateReqCTransfer
 * <p>服务创建命令请求传输对象
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
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
@JSONType(orders = {"projectId", "serviceArtifactId", "name", "description",
        "version", "author", "rootPath", "basePackage", "classNamePrefix",
        "type", "port"})
public record ServiceCreateReqCTransfer(
        @NotBlank(message = "项目ID不能为空") String projectId,
        @NotBlank(message = "服务构件ID不能为空") String serviceArtifactId,
        @NotBlank(message = "服务名称不能为空") String name,
        @NotBlank(message = "服务描述不能为空") String description,
        @NotBlank(message = "服务作者不能为空") String author,
        @NotBlank(message = "服务根路径不能为空") String rootPath,
        @NotBlank(message = "服务基础包名不能为空") String basePackage,
        @NotBlank(message = "服务类名前缀不能为空") String classNamePrefix,
        @NotBlank(message = "服务类型不能为空") String type,
        @NotNull(message = "服务端口不能为空") @Port Integer port
) implements DDDGeneratorCommandTransfer {

    @Override
    public ServiceCreateReqCTransfer validate() {
        return this;
    }
}
