package org.endless.domain.simplified.server.supporting.security.token.domain.type;

import org.endless.domain.simplified.server.common.model.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.domain.type.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * TokenTypeEnum
 * <p>令牌类型枚举
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerEnum
 * @since 2.0.0
 */
@Getter
@AllArgsConstructor
@ToString
public enum TokenTypeEnum implements DomainSimplifiedServerEnum {

    AUTHENTICATION("AUTHENTICATION", "身份认证令牌"),
    REFRESH("REFRESH", "刷新令牌");

    private final String code;

    private final String description;

    public static TokenTypeEnum fromCode(String code) {
        for (TokenTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的TokenTypeEnum: " + code);
    }
}
