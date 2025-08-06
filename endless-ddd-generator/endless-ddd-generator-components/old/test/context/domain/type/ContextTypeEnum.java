package org.endless.ddd.generator.components.generator.context.domain.type;

import lombok.Getter;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;

/**
 * DomainAdapterTypeEnum
 * <p>
 * 限界上下文类型枚举
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorEnum
 * @since 0.0.1
 */
@Getter
public enum ContextTypeEnum implements DDDGeneratorEnum {

    COMPONENT("Component", "核心组件域"),
    SUPPORTING("Supporting", "支撑域");

    private final String code;

    private final String description;

    ContextTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ContextTypeEnum fromCode(String code) {
        for (ContextTypeEnum value : ContextTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("未知的限界上下文类型枚举代码: " + code);
    }
}
