package org.endless.ddd.generator.components.generator.service.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.generator.components.generator.service.domain.type.ServiceTypeEnum;
import org.endless.ddd.starter.common.annotation.validate.ddd.aggregate.Aggregate;
import org.endless.ddd.starter.common.annotation.validate.number.port.Port;
import org.endless.ddd.starter.common.annotation.validate.number.time.TimeStamp;
import org.endless.ddd.starter.common.annotation.validate.string.cases.Path;
import org.endless.ddd.starter.common.annotation.validate.string.cases.UpperCamelCase;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.ddd.starter.common.utils.model.time.TimeStampTools;
import org.springframework.validation.annotation.Validated;

/**
 * ServiceAggregate
 * <p>服务聚合根
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
 * @author Deng Haozhi
 * @see DDDGeneratorAggregate
 * @since 1.0.0
 */
@Aggregate
@Validated
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ServiceAggregate implements DDDGeneratorAggregate {

    /**
     * 服务ID
     */
    @NotBlank(message = "服务ID不能为空")
    private final String serviceId;

    /**
     * 项目ID
     */
    @NotBlank(message = "项目ID不能为空")
    private String projectId;

    /**
     * 服务构件ID
     */
    @NotBlank(message = "服务构件ID不能为空")
    private String serviceArtifactId;

    /**
     * 服务名称
     */
    @NotBlank(message = "服务名称不能为空")
    private String name;

    /**
     * 服务描述
     */
    @NotBlank(message = "服务描述不能为空")
    private String description;

    /**
     * 服务作者
     */
    @NotBlank(message = "服务作者不能为空")
    private String author;

    /**
     * 服务根路径
     */
    @Path
    @NotBlank(message = "服务根路径不能为空")
    private String rootPath;

    /**
     * 服务基础包名
     */
    @NotBlank(message = "服务基础包名不能为空")
    private String basePackage;

    /**
     * 服务类名前缀
     */
    @UpperCamelCase
    @NotBlank(message = "服务类名前缀不能为空")
    private String classNamePrefix;

    /**
     * 服务类型
     */
    @NotNull(message = "服务类型不能为空")
    private ServiceTypeEnum type;

    /**
     * 服务端口
     */
    @Port
    @NotNull(message = "服务端口不能为空")
    private Integer port;

    /**
     * 服务创建时间
     */
    @TimeStamp
    @NotNull(message = "服务创建时间不能为空")
    private Long createAt;

    /**
     * 服务修改时间
     */
    @TimeStamp
    @NotNull(message = "服务修改时间不能为空")
    private Long modifyAt;

    /**
     * 创建者ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private final String createUserId;

    /**
     * 修改者ID
     */
    @NotBlank(message = "修改用户ID不能为空")
    private String modifyUserId;

    /**
     * 是否已删除
     */
    @NotNull(message = "是否已删除不能为空")
    private Boolean isRemoved;

    public static ServiceAggregate create(
            @NotNull(message = "服务聚合创建对象不能为空") ServiceAggregateBuilder builder) {
        Long now = TimeStampTools.now();
        builder.createAt(now).modifyAt(now);
        return (ServiceAggregate) Entity.create(builder, ServiceAggregateBuilder::innerBuild);
    }

    public ServiceAggregate remove(
            @NotNull(message = "修改用户ID不能为空") String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<服务聚合根>不能再次删除, ID: " + serviceId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ServiceAggregate modify(
            @NotNull(message = "服务聚合修改对象不能为空") ServiceAggregateBuilder builder) {
        this.projectId = builder.projectId == null ? this.projectId : builder.projectId;
        this.serviceArtifactId = builder.serviceArtifactId == null ? this.serviceArtifactId : builder.serviceArtifactId;
        this.name = builder.name == null ? this.name : builder.name;
        this.description = builder.description == null ? this.description : builder.description;
        this.author = builder.author == null ? this.author : builder.author;
        this.rootPath = builder.rootPath == null ? this.rootPath : builder.rootPath;
        this.basePackage = builder.basePackage == null ? this.basePackage : builder.basePackage;
        this.classNamePrefix = builder.classNamePrefix == null ? this.classNamePrefix : builder.classNamePrefix;
        this.type = builder.type == null ? this.type : builder.type;
        this.port = builder.port == null ? this.port : builder.port;
        this.modifyAt = TimeStampTools.now();
        this.modifyUserId = builder.modifyUserId;
        return ObjectTools.JSRValidate(this).validate();
    }

    @Override
    public ServiceAggregate validate() {
        return this;
    }
}
