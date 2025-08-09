package org.endless.ddd.generator.components.generator.domain.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * AggregateFieldTypeEnum
 * <p>聚合根字段类型枚举
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DDDGeneratorEnum
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
@ToString
public enum AggregateFieldTypeEnum implements DDDGeneratorEnum {

    STRING("STRING", "String"),
    INTEGER("INTEGER", "Integer"),
    LONG("LONG", "Long"),
    DOUBLE("DOUBLE", "Double"),
    ENTITY("ENTITY", "Entity"),
    VALUE("VALUE", "Value"),
    ENUM("ENUM", "Enum"),
    LIST_STRING("LIST_STRING", "List<String>"),
    LIST_ENTITY("LIST_ENTITY", "List<Entity>"),
    BIG_DECIMAL("BIG_DECIMAL", "BigDecimal");

    private final String code;

    private final String description;

    public static AggregateFieldTypeEnum fromCode(String code) {
        for (AggregateFieldTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的聚合根字段类型枚举: " + code);
    }
}
