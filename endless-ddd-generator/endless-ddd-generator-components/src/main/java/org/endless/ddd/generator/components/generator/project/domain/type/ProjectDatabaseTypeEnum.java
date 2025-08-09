package org.endless.ddd.generator.components.generator.project.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * ProjectDatabaseTypeEnum
 * <p>项目数据库类型枚举
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
public enum ProjectDatabaseTypeEnum implements DDDGeneratorEnum {

    MYSQL("MYSQL", "MySQL数据库");

    private final String code;

    private final String description;

    public static ProjectDatabaseTypeEnum fromCode(String code) {
        for (ProjectDatabaseTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的项目数据库类型枚举: " + code);
    }
}
