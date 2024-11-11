package org.endless.ddd.simplified.generator.object.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * AggregateDTO
 * <p>
 * create 2024/10/17 09:21
 * <p>
 * update 2024/10/17 09:21
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@Builder
@ToString
public class AggregateDTO {

    private final String serviceName;

    private final String contextName;

    private final String domainName;

    private final String aggregateName;

    public AggregateDTO validate() {
        validateServiceName();
        validateContextName();
        validateDomainName();
        validateAggregateName();
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
}
