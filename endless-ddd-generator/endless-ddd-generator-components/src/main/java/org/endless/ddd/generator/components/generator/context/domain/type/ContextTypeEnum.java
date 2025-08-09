package org.endless.ddd.generator.components.generator.context.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * ContextTypeEnum
 * <p>服务类型枚举
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see DDDGeneratorEnum
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
@ToString
public enum ContextTypeEnum implements DDDGeneratorEnum {

    COMPONENT("COMPONENT", "核心组件域"),
    SUPPORTING("SUPPORTING", "支撑域");

    private final String code;

    private final String description;

    public static ContextTypeEnum fromCode(String code) {
        for (ContextTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的服务类型枚举: " + code);
    }
}
