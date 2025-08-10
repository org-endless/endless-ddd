package org.endless.ddd.starter.common.ddd.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.TableId;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;

import java.lang.reflect.Field;

/**
 * DataRecord
 * <p>DDD数据仓储实体类
 * <p>不同的持久化框架使用不同注解实现
 * <p>
 * create 2024/09/03 11:34
 * <p>
 * update 2024/11/03 13:48
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface DataRecord<E extends Entity> {

    DataRecord<E> validate();

    /**
     * 获取记录修改时间
     *
     * @return {@link Long }
     */
    Long getModifyAt();

    Boolean getIsRemoved();

    Long getRemoveAt();

    /**
     * 获取数据库记录实体ID名称
     *
     * @return {@link String} ID 字段名称
     */
    default String idName() {
        return idField().getName();
    }

    /**
     * 获取数据库记录实体ID值
     *
     * @return {@link String} ID 字段值
     */
    default String idValue() {
        try {
            Field idField = idField();
            idField.setAccessible(true);
            return idField.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new DataRecordValidateException("无法访问数据库实体的 ID 字段", e);
        } catch (NullPointerException e) {
            throw new DataRecordValidateException("数据库实体的 ID 字段值为 null", e);
        } catch (IllegalArgumentException e) {
            throw new DataRecordValidateException("获取数据库实体的 ID 字段值时的参数不合法", e);
        }
    }

    /**
     * 查找实体类中的 ID 字段
     *
     * @return {@link Field} ID 字段
     */
    default Field idField() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getName().endsWith("Id") && field.isAnnotationPresent(TableId.class)) {
                return field;
            }
        }
        throw new DataRecordValidateException("未找到数据库实体的 ID 字段");
    }
}
