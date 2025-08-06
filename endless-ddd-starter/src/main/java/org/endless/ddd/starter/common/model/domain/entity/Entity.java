package org.endless.ddd.starter.common.model.domain.entity;

import org.endless.ddd.starter.common.exception.model.domain.entity.EntityException;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Entity
 * <p>DDD实体类型模版
 * <p>
 * create 2024/02/04 15:39
 * <p>
 * update 2024/08/30 09:03
 * <p>
 * <p>
 * <p>
 * update 2024/09/06 13:03
 *
 * @author Deng Haozhi
 * @see Serializable
 * @since 1.0.0
 */
public interface Entity extends Serializable {

    Entity validate();

    default String getIdField(Entity entity) {
        try {
            Class<?> entityClass = entity.getClass();
            // 查找以 "Id" 结尾的字段
            for (Field field : entityClass.getDeclaredFields()) {
                if (field.getName().endsWith("Id")) {
                    return field.getName();
                }
            }
            throw new IllegalArgumentException("实体类中没有找到以 'Id' 结尾的字段");
        } catch (Exception e) {
            throw new EntityException("获取聚合或实体 ID 属性名异常: " + e.getMessage(), e);
        }
    }

    default String getIdFieldValue(Entity entity) {
        try {
            Class<?> entityClass = entity.getClass();
            Field idField = null;
            for (Field field : entityClass.getDeclaredFields()) {
                if (field.getName().endsWith("Id")) {
                    idField = field;
                    break;
                }
            }
            if (idField == null) {
                throw new IllegalArgumentException("聚合或实体类中没有找到以 'Id' 结尾的字段");
            }
            idField.setAccessible(true);
            // 获取实体的 ID 值
            return (String) idField.get(entity);
        } catch (Exception e) {
            throw new EntityException("获取聚合或实体 ID 属性值异常: " + e.getMessage(), e);
        }
    }
}
