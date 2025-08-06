package org.endless.ddd.generator.components.generator.project.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.model.domain.type.EnumException;

/**
 * ProjectJavaVersionEnum
 * <p>项目Java版本枚举
 * <p>
 * create 2025/08/05 21:18
 * <p>
 * update 2025/08/05 21:18
 *
 * @author Deng Haozhi
 * @see DDDGeneratorEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum ProjectJavaVersionEnum implements DDDGeneratorEnum {

    JAVA8("JAVA8", "Java 1.8"),
    JAVA21("JAVA21", "Java 21");

    private final String code;

    private final String description;

    public static ProjectJavaVersionEnum fromCode(String code) {
        for (ProjectJavaVersionEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的项目Java版本枚举: " + code);
    }
}
