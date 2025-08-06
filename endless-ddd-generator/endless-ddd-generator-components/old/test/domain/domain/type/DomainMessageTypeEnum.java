package org.endless.ddd.generator.components.generator.domain.domain.type;

import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.model.domain.type.EnumException;

/**
 * DomainMessageTypeEnum
 * <p>
 * 领域消息类型枚举
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
@ToString
public enum DomainMessageTypeEnum implements DDDGeneratorEnum {

    REQUEST("REQUEST", "请求"),
    RESPONSE("RESPONSE", "响应");

    private final String code;

    private final String description;

    DomainMessageTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DomainMessageTypeEnum fromCode(String code) {
        for (DomainMessageTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的领域消息类型枚举: " + code);
    }
}
