package org.endless.ddd.generator.components.generators;

import org.endless.ddd.generator.components.generator.domain.domain.entity.Enum;
import org.endless.ddd.generator.components.generator.domain.domain.entity.Field;
import org.endless.ddd.generator.object.entity.Aggregate;
import org.endless.ddd.generator.object.value.EnumValue;

import java.io.IOException;
import java.util.List;

import static org.endless.ddd.generator.template.CommentTemplate.comment;
import static org.endless.ddd.generator.template.DefineTemplate.enumDefine;
import static org.endless.ddd.generator.template.EndTemplate.end;
import static org.endless.ddd.generator.template.FieldTemplate.enumFields;
import static org.endless.ddd.generator.template.FieldTemplate.enumValues;
import static org.endless.ddd.generator.template.HeaderTemplate.importHeaderEnum;
import static org.endless.ddd.generator.template.HeaderTemplate.packageHeader;
import static org.endless.ddd.generator.template.MethodTemplate.fromCode;
import static org.endless.ddd.generator.utils.DDDUtils.*;

/**
 * EnumTemplate
 * <p>
 * create 2024/09/19 17:24
 * <p>
 * update 2024/09/19 17:24
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class EnumGenerator {

    /**
     * 生成枚举类
     *
     * @param aggregate  配置信息
     * @param enumObject 枚举信息
     * @throws IOException IO异常
     */
    public void generateEnum(Aggregate aggregate, Enum enumObject) throws Exception {
        String classDescription = enumObject.getDescription() + "枚举";
        generate(aggregate, enumObject.getEnumValues(), enumObject.getFields(), enumObject.getName(), classDescription);
    }

    /**
     * 代码生成器
     *
     * @param aggregate 聚合信息
     * @param values    枚举值列表
     * @param fields    枚举属性列表
     * @param className 枚举类名称
     * @throws Exception 异常
     */
    private void generate(Aggregate aggregate, List<EnumValue> values, List<Field> fields, String className, String classDescription) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();

        String subPackage = "domain.type";
        String packageName = domainPackage(aggregate) + "." + subPackage;
        String superClassName = superClassName(aggregate.getServiceName(), className, 1);
        String rootPath = aggregate.getRootPath();


        packageHeader(stringBuilder, packageName);
        importHeaderEnum(stringBuilder, aggregate.getGroupId(), servicePackage(aggregate), subPackage);
        comment(stringBuilder, className, superClassName, classDescription, aggregate.getAuthor(), aggregate.getVersion());
        enumDefine(stringBuilder, className, superClassName);
        enumValues(stringBuilder, values, fields, className);
        enumFields(stringBuilder, fields);
        fromCode(stringBuilder, fields, className, classDescription);
        end(stringBuilder);

        deleteFileIfExists(rootPath, packageName, className);
        writeFile(rootPath, packageName, className, stringBuilder.toString());
    }
}
