package org.endless.ddd.simplified.generator.generators;

import org.endless.ddd.simplified.generator.object.entity.Aggregate;
import org.endless.ddd.simplified.generator.object.entity.Entity;
import org.endless.ddd.simplified.generator.object.entity.Field;
import org.endless.ddd.simplified.generator.object.entity.Value;
import org.endless.ddd.simplified.generator.utils.DDDUtils;
import org.endless.ddd.simplified.generator.utils.StringTools;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.endless.ddd.simplified.generator.template.CommentTemplate.comment;
import static org.endless.ddd.simplified.generator.template.DefineTemplate.classDefineRecord;
import static org.endless.ddd.simplified.generator.template.EndTemplate.end;
import static org.endless.ddd.simplified.generator.template.FieldTemplate.*;
import static org.endless.ddd.simplified.generator.template.HeaderTemplate.importHeaderRecord;
import static org.endless.ddd.simplified.generator.template.HeaderTemplate.packageHeader;
import static org.endless.ddd.simplified.generator.template.MethodTemplate.*;
import static org.endless.ddd.simplified.generator.template.ValidateTemplate.validate;
import static org.endless.ddd.simplified.generator.template.ValidateTemplate.validateMethods;

/**
 * DataRecordGenerator
 * <p>
 * create 2024/09/18 11:42
 * <p>
 * update 2024/09/18 11:42
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class DataRecordGenerator {

    public void generateAggregate(Aggregate aggregate) throws Exception {
        String className = exchangeSuffix(aggregate.getAggregateName(), "Record", 1);
        String tableName = aggregate.getContextName() + "_" + snakeCase(removeSuffix(className, "Record"));
        String classDescription = aggregate.getDescription() + "数据库记录实体";

        generate(aggregate, aggregate.getFields(), className, tableName, aggregate.getAggregateName(), aggregate.getDescription(), classDescription);
    }

    public void generateEntity(Aggregate aggregate, Entity entity) throws Exception {
        String className = exchangeSuffix(entity.getName(), "Record", 1);
        String tableName = aggregate.getContextName() + "_" + snakeCase(removeSuffix(aggregate.getAggregateName(), "Aggregate")) + "_" + snakeCase(removeSuffix(className, "Record"));
        String classDescription = entity.getDescription() + "数据库记录实体";

        generate(aggregate, entity.getFields(), className, tableName, entity.getName(), aggregate.getAggregateName(), classDescription);
    }

    public void generateAssociation(Aggregate aggregate, Entity entity) throws Exception {
        String generics = entity.getName();
        String genericDescription = entity.getDescription();
        String classDescription = aggregate.getDescription() + entity.getDescription() + "关系数据库记录实体";

        List<Field> fields = aggregate.getFields();
        for (Field field : fields) {
            String fieldType = field.getType();

            if (fieldType.startsWith("List<")) {
                String fieldGenerics = generics(fieldType);
                if (fieldGenerics.equals("String") || fieldGenerics.equals("Long")) {
                    String associationClassName = removeSuffix(generics, 1) + StringUtils.capitalize(exchangeSuffix(field.getName(), "AssociationRecord", 1));
                    String tableName = aggregate.getContextName() + "_" + snakeCase(removeSuffix(aggregate.getAggregateName(), "Aggregate")) + "_" + snakeCase(removeSuffix(associationClassName, "Record"));
                    List<Field> associationFields = new ArrayList<>();
                    associationFields.add(Field.builder().name("associationId").type(fieldGenerics).description("关系ID").nullable(false).build());
                    for (Field idField : fields) {
                        if (idField.getName().equals(id(generics, 1))) {
                            associationFields.add(idField);
                        }
                    }
                    associationFields.add(Field.builder().name(removeSuffix(field.getName(), "s")).type(fieldGenerics).description(removeSuffix(field.getDescription(), "列表")).nullable(false).build());
                    generate(aggregate, associationFields, associationClassName, generics, genericDescription, tableName, classDescription);
                }
            }
        }
    }

    private void generate(Aggregate aggregate, List<Field> fields, String className, String tableName, String generics, String genericDescription, String classDescription) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        String domainPackage = domainPackage(aggregate);
        String subPackage = "infrastructure.data.record";
        String packageName = domainPackage + "." + subPackage;
        String superClassName = superClassName(aggregate.getServiceName(), className, 1);
        String superClassNameWithGenerics = superClassNameWithGenerics(superClassName, generics);
        Set<String> entityNames = entityNames(aggregate);
        Set<String> valueNames = valueNames(aggregate);
        List<Value> values = aggregate.getValues();
        List<Field> defaultFields = addDefaultFields(fields, className);
        List<Field> newFields;
        String aggregateName = aggregate.getAggregateName();
        newFields = addDefaultFields(recordFields(fields, values, aggregateName, className, generics, genericDescription), className);
        String rootPath = aggregate.getRootPath();

        packageHeader(stringBuilder, packageName);
        importHeaderRecord(stringBuilder, aggregate.getGroupId(), servicePackage(aggregate), domainPackage, subPackage, !valueNames.isEmpty(), !enumNames(aggregate).isEmpty());
        comment(stringBuilder, className, superClassName, classDescription, aggregate.getAuthor(), aggregate.getVersion());
        classDefineRecord(stringBuilder, className, superClassNameWithGenerics, tableName);
        fields(stringBuilder, entityNames, valueNames, newFields, className);
        from(stringBuilder, entityNames, values, defaultFields, aggregateName, className, generics);
        to(stringBuilder, entityNames, values, defaultFields, className, generics);
        add(stringBuilder, entityNames, newFields, className);
        validate(stringBuilder, newFields, className);
        validateMethods(stringBuilder, newFields, className);
        end(stringBuilder);

        deleteFileIfExists(rootPath, packageName, className);
        writeFile(rootPath, packageName, className, stringBuilder.toString());
    }
}
