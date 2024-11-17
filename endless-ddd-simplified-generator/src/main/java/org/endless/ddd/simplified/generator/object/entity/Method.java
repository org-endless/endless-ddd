package org.endless.ddd.simplified.generator.object.entity;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Method
 * <p>
 * create 2024/10/18 08:45
 * <p>
 * update 2024/10/18 08:45
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Builder
@ToString
@JSONType(orders = {"name", "returnType", "description", "fields"})
public class Method {

    private final String name;

    private final String returnType;

    private final String description;

    private final List<Field> fields;

    public Method validate() {
        validateName();
        validateReturnType();
        validateDescription();
        validateFields();
        return this;
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("行为方法名称不能为空，当前值为: " + name);
        }
    }

    private void validateReturnType() {
        if (!StringUtils.hasText(returnType)) {
            throw new IllegalArgumentException("行为方法返回类型不能为空，当前值为: " + returnType);
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new IllegalArgumentException("行为方法描述不能为空，当前值为: " + description);
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
