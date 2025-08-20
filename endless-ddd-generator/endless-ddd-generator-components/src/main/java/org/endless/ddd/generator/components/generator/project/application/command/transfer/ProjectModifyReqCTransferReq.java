package org.endless.ddd.generator.components.generator.project.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorReqCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ProjectModifyReqCTransferReq
 * <p>项目修改命令请求传输对象
 * <p>
 * create 2025/08/05 21:59
 * <p>
 * update 2025/08/05 21:59
 *
 * @param projectId            项目ID
 * @param projectArtifactId    项目构件ID
 * @param groupId              项目组织ID
 * @param name                 项目名称
 * @param description          项目描述
 * @param version              项目版本号
 * @param author               项目作者
 * @param rootPath             项目根路径
 * @param basePackage          项目基础包名
 * @param enableSpringDoc      项目是否启用Spring Doc
 * @param javaVersion          项目Java版本
 * @param loggingFramework     项目日志框架
 * @param persistenceFramework 项目持久化框架
 * @param databaseType         项目数据库类型
 * @author Deng Haozhi
 * @see DDDGeneratorReqCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"projectId", "projectArtifactId", "groupId", "name", "description", "version", "author", "rootPath", "basePackage", "enableSpringDoc", "javaVersion", "loggingFramework", "persistenceFramework", "databaseType"})
public record ProjectModifyReqCTransferReq(
        String projectId, String projectArtifactId, String groupId, String name,
        String description, String version, String author, String rootPath,
        String basePackage, Boolean enableSpringDoc, String javaVersion,
        String loggingFramework, String persistenceFramework,
        String databaseType) implements DDDGeneratorReqCommandTransfer {

    @Override
    public ProjectModifyReqCTransferReq validate() {
        validateProjectId();
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new CommandReqTransferValidateException("项目ID不能为空");
        }
    }
}
