package org.endless.ddd.simplified.generator.object.type;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * EnumValue
 * <p>
 * create 2024/09/19 18:06
 * <p>
 * update 2024/09/19 18:06
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Builder
@ToString
@JSONType(orders = {"code", "description"})
public class EnumValue {

    private final String code;

    private final String description;

    public EnumValue validate() {
        validateCode();
        validateDescription();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new IllegalArgumentException("枚举值代码不能为空，当前值为: " + code);
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new IllegalArgumentException("枚举值描述不能为空，当前值为: " + description);
        }
    }
}
