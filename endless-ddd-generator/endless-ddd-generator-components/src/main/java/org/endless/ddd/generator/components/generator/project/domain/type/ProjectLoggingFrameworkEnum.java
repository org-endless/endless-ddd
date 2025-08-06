package org.endless.ddd.generator.components.generator.project.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.type.DDDGeneratorEnum;
import org.endless.ddd.starter.common.exception.model.domain.type.EnumException;

/**
 * ProjectLoggingFrameworkEnum
 * <p>项目日志框架枚举
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
public enum ProjectLoggingFrameworkEnum implements DDDGeneratorEnum {

    LOG4J2("LOG4J2", "log4j2框架");

    private final String code;

    private final String description;

    public static ProjectLoggingFrameworkEnum fromCode(String code) {
        for (ProjectLoggingFrameworkEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的项目日志框架枚举: " + code);
    }
}
