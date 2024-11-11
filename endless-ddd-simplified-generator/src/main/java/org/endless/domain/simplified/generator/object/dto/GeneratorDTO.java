package org.endless.domain.simplified.generator.object.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * GeneratorDTO
 * <p>
 * create 2024/10/17 09:13
 * <p>
 * update 2024/10/17 09:13
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@Builder
@ToString
public class GeneratorDTO {

    private final String serviceName;

    private String contextName;

    private String domainName;

    private String aggregateName;

    private Boolean enableEntity;

    private Boolean enableRecord;

    private Boolean enableValue;

    private Boolean enableEnum;

    private Boolean enableRepository;

    private Boolean enableCommandHandler;

    private Boolean enableCommandTransfer;

    private Boolean enableQueryHandler;

    private Boolean enableQueryTransfer;

    private Boolean enableDataManager;

    private Boolean enableMapper;

    private Boolean enableDrivenTransfer;

    private Boolean enableDrivingAdapter;

    private Boolean enableController;

    public GeneratorDTO validate() {
        validateServiceName();
        validateContextName();
        validateDomainName();
        validateAggregateName();
        validateEnableEntity();
        validateEnableRecord();
        validateEnableValue();
        validateEnableEnum();
        validateEnableRepository();
        validateEnableCommandHandler();
        validateEnableCommandTransfer();
        validateEnableQueryHandler();
        validateEnableQueryTransfer();
        validateEnableDataManager();
        validateEnableMapper();
        validateEnableDrivingAdapter();
        validateEnableController();

        return this;
    }

    private void validateServiceName() {
        if (!StringUtils.hasText(serviceName)) {
            throw new IllegalArgumentException("服务名称不能为空，当前值为：" + serviceName);
        }
    }

    private void validateContextName() {
        if (!StringUtils.hasText(contextName)) {
            throw new IllegalArgumentException("上下文名称不能为空，当前值为：" + contextName);
        }
    }

    private void validateDomainName() {
        if (!StringUtils.hasText(domainName)) {
            throw new IllegalArgumentException("领域名称不能为空，当前值为：" + domainName);
        }
    }

    private void validateAggregateName() {
        if (!StringUtils.hasText(aggregateName)) {
            throw new IllegalArgumentException("聚合名称不能为空，当前值为：" + aggregateName);
        }
    }

    private void validateEnableEntity() {
        if (enableEntity == null) {
            throw new IllegalArgumentException("是否生成实体类不能为空");
        }
    }

    private void validateEnableRecord() {
        if (enableRecord == null) {
            throw new IllegalArgumentException("是否生成记录类不能为空");
        }
    }

    private void validateEnableValue() {
        if (enableValue == null) {
            throw new IllegalArgumentException("是否生成值对象不能为空");
        }
    }

    private void validateEnableEnum() {
        if (enableEnum == null) {
            throw new IllegalArgumentException("是否生成枚举类不能为空");
        }
    }

    private void validateEnableRepository() {
        if (enableRepository == null) {
            throw new IllegalArgumentException("是否生成仓储类不能为空");
        }
    }

    private void validateEnableCommandHandler() {
        if (enableCommandHandler == null) {
            throw new IllegalArgumentException("是否生成命令处理器不能为空");
        }
    }

    private void validateEnableCommandTransfer() {
        if (enableCommandTransfer == null) {
            throw new IllegalArgumentException("是否生成命令传输对象不能为空");
        }
    }

    private void validateEnableQueryHandler() {
        if (enableQueryHandler == null) {
            throw new IllegalArgumentException("是否生成查询处理器不能为空");
        }
    }

    private void validateEnableQueryTransfer() {
        if (enableQueryTransfer == null) {
            throw new IllegalArgumentException("是否生成查询传输对象不能为空");
        }
    }

    private void validateEnableDataManager() {
        if (enableDataManager == null) {
            throw new IllegalArgumentException("是否生成数据管理类不能为空");
        }
    }

    private void validateEnableMapper() {
        if (enableMapper == null) {
            throw new IllegalArgumentException("是否生成 Mybatis 数据库映射器不能为空");
        }
    }

    private void validateEnableDrivingAdapter() {
        if (enableDrivingAdapter == null) {
            throw new IllegalArgumentException("是否生成主动适配器不能为空");
        }
    }

    private void validateEnableController() {
        if (enableController == null) {
            throw new IllegalArgumentException("是否生成Web控制器不能为空");
        }
    }
}
