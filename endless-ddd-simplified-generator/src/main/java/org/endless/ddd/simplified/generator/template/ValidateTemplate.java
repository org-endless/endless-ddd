package org.endless.ddd.simplified.generator.template;

import org.endless.ddd.simplified.generator.object.entity.Field;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * ValidateTemplate
 * <p>
 * create 2024/09/19 01:18
 * <p>
 * update 2024/09/19 01:18
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class ValidateTemplate {

    /**
     * 生成校验方法
     *
     * @param stringBuilder 字符串构建器
     * @param fields        字段列表
     */
    public static void validate(StringBuilder stringBuilder, List<Field> fields, String className) {

        stringBuilder
                .append("    @Override\n")
                .append("    public ").append(className).append(" validate() {\n");
        for (Field field : fields) {
            if (!field.getNullable()) {
                stringBuilder.append("        validate").append(StringUtils.capitalize(field.getName())).append("();\n");
            }
        }
        stringBuilder
                .append("        return this;\n")
                .append("    }\n\n");
    }

    /**
     * 按属性生成校验方法
     *
     * @param stringBuilder 字符串构建器
     * @param fields        字段列表
     * @param className     类名
     */
    public static void validateMethods(StringBuilder stringBuilder, List<Field> fields, String className) {

        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType();
            String fieldDescription = field.getDescription();

            // 检查条件，如果符合，则生成校验方法
            if (!field.getNullable()) {

                stringBuilder.append("    private void validate").append(StringUtils.capitalize(fieldName)).append("() {\n");

                // 针对不同类型进行校验逻辑生成
                if ("String".equals(fieldType)) {
                    appendStringValidation(stringBuilder, fieldName, fieldDescription);
                } else if (isNumericType(fieldType)) {
                    appendNumericValidation(stringBuilder, fieldName, fieldDescription);
                } else if (fieldType.startsWith("List<")) {
                    appendListValidation(stringBuilder, fieldName, fieldDescription);
                } else {
                    appendDefaultValidation(stringBuilder, fieldName, fieldDescription);
                }

                stringBuilder.append("    }\n\n");
            }
        }
    }

    private static void appendStringValidation(StringBuilder stringBuilder, String fieldName, String fieldDescription) {
        stringBuilder
                .append("        if (!StringUtils.hasText(").append(fieldName).append(")) {\n")
                .append("            throw new ValidateException(\"").append(fieldDescription).append("不能为空\");\n")
                .append("        }\n");
    }

    private static void appendNumericValidation(StringBuilder stringBuilder, String fieldName, String fieldDescription) {
        stringBuilder
                .append("        if (").append(fieldName).append(" == null || ").append(fieldName).append(" < 0) {\n")
                .append("            throw new ValidateException(\"").append(fieldDescription).append("不能为 null 或小于 0，当前值为：\" + ").append(fieldName).append(");\n")
                .append("        }\n");
    }

    private static void appendListValidation(StringBuilder stringBuilder, String fieldName, String fieldDescription) {
        stringBuilder
                .append("        if (").append(fieldName).append(" == null || ").append(fieldName).append(".isEmpty()) {\n")
                .append("            throw new ValidateException(\"").append(fieldDescription).append("不能为 null 或空\");\n")
                .append("        }\n");
    }

    private static void appendDefaultValidation(StringBuilder stringBuilder, String fieldName, String fieldDescription) {
        stringBuilder
                .append("        if (").append(fieldName).append(" == null) {\n")
                .append("            throw new ValidateException(\"").append(fieldDescription).append("不能为 null\");\n")
                .append("        }\n");
    }

    private static boolean isNumericType(String fieldType) {
        return "Long".equals(fieldType) || "Integer".equals(fieldType) || "Double".equals(fieldType);
    }
}
