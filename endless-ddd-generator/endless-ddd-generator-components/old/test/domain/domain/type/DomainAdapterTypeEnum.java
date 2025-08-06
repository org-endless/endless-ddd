package org.endless.ddd.generator.components.generator.domain.domain.type;

import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.model.domain.type.EnumException;

/**
 * DomainAdapterTypeEnum
 * <p>
 * 领域适配器类型
 * <p>
 * create 2024/10/23 09:35
 * <p>
 * update 2024/10/23 09:35
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@ToString
public enum DomainAdapterTypeEnum {

    DRIVING("DRIVING", "主动适配器"),
    DRIVEN("DRIVEN", "被动适配器");

    private final String code;

    private final String description;

    DomainAdapterTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DomainAdapterTypeEnum fromCode(String code) {
        for (DomainAdapterTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的领域适配器类型枚举: " + code);
    }
}
