package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorReqCommandTransfer;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorRespCommandTransfer;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.ddd.starter.common.annotation.validate.number.port.Port;
import org.endless.ddd.starter.common.annotation.validate.string.cases.ArtifactId;
import org.endless.ddd.starter.common.annotation.validate.string.cases.PackageName;
import org.endless.ddd.starter.common.annotation.validate.string.cases.TransferPath;
import org.endless.ddd.starter.common.annotation.validate.string.cases.UpperCamelCase;

/**
 * ServiceCreateReqCTransferReq
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
 * @see DDDGeneratorReqCommandTransfer
 * @since 1.0.0
 */
@Transfer
@Builder
@JSONType(orders = {"projectId", "serviceArtifactId", "name", "description",
        "version", "author", "rootPath", "basePackage", "classNamePrefix",
        "type", "port"})
public record ServiceCreateReqCTransfer(
        @NotBlank(message = "项目ID不能为空") String projectId,
        @NotBlank(message = "服务构件ID不能为空") @ArtifactId String serviceArtifactId,
        @NotBlank(message = "服务名称不能为空") String name,
        @NotBlank(message = "服务描述不能为空") String description,
        @NotBlank(message = "服务作者不能为空") String author,
        @NotBlank(message = "服务根路径不能为空") @TransferPath String rootPath,
        @NotBlank(message = "服务基础包名不能为空") @PackageName String basePackage,
        @NotBlank(message = "服务类名前缀不能为空") @UpperCamelCase String classNamePrefix,
        @NotBlank(message = "服务类型不能为空") String type,
        @NotNull(message = "服务端口不能为空") @Port Integer port
) implements DDDGeneratorRespCommandTransfer {

    @Override
    public ServiceCreateReqCTransfer validate() {
        return this;
    }
}
