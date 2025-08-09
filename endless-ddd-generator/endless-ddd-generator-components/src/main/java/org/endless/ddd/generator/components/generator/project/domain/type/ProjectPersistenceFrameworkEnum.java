package org.endless.ddd.generator.components.generator.project.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * ProjectPersistenceFrameworkEnum
 * <p>项目持久化框架枚举
 * <p>
 * create 2025/08/05 21:18
 * <p>
 * update 2025/08/05 21:18
 *
 * @author Deng Haozhi
 * @see DDDGeneratorEnum
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
@ToString
public enum ProjectPersistenceFrameworkEnum implements DDDGeneratorEnum {

    JPA("JPA", "JPA框架"),
    MYBATIS_PLUS("MYBATIS_PLUS", "Mybatis-Plus框架");

    private final String code;

    private final String description;

    public static ProjectPersistenceFrameworkEnum fromCode(String code) {
        for (ProjectPersistenceFrameworkEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的项目持久化框架枚举: " + code);
    }
}
