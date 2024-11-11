package org.endless.ddd.simplified.generator.object.entity;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Value
 * <p>
 * create 2024/09/18 00:02
 * <p>
 * update 2024/09/18 00:02
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@Builder
@ToString
@JSONType(orders = {"name", "returnType", "description", "fields"})
public class Value {

    private final String name;

    private final String description;

    private final List<Field> fields;

    public void validate() {
        validateName();
        validateDescription();
        validateFields();
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("值对象名称不能为空，当前值为：" + name);
        }
        if (!name.endsWith("Value")) {
            throw new IllegalArgumentException("值对象名称必须以Value结尾，请修改： " + name);
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new IllegalArgumentException("值对象描述不能为空，当前值为：" + description);
        }
    }

    private void validateFields() {
        if (fields != null && !fields.isEmpty()) {
            fields.forEach(Field::validate);
        } else {
            throw new IllegalArgumentException("实体字段不能为空");
        }
    }
}
