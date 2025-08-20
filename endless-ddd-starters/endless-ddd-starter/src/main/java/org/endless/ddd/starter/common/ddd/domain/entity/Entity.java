package org.endless.ddd.starter.common.ddd.domain.entity;

import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateCreateException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.entity.EntityCreateException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.entity.EntityException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;

import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * Entity
 * <p>实体
 * <p>DDD领域层
 * <p>用于处理领域内部逻辑，领域模型载体
 * <p>聚合根与聚合根的子实体可以是一对多的关系
 * <p>
 * create 2024/02/04 15:39
 * <p>
 * update 2024/09/06 13:03
 *
 * @author Deng Haozhi
 * @see Serializable
 * @since 1.0.0
 */
public interface Entity extends Serializable {

    static <B, E extends Entity> E create(B builder, Function<B, E> buildFunction) {
        String className = builder.getClass().getSimpleName();
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            Field field = builder.getClass().getDeclaredField("createUserId");
            MethodHandle createUserIdGetter = lookup.unreflectGetter(field);
            MethodHandle idHandle = lookup.findVirtual(builder.getClass(), id(className), MethodType.methodType(builder.getClass(), String.class));
            MethodHandle modifyUserIdHandle = lookup.findVirtual(builder.getClass(), "modifyUserId", MethodType.methodType(builder.getClass(), String.class));
            MethodHandle isRemovedHandle = lookup.findVirtual(builder.getClass(), "isRemoved", MethodType.methodType(builder.getClass(), Boolean.class));

            builder = invokeBuilder(idHandle, builder, IdGenerator.of());
            builder = invokeBuilder(modifyUserIdHandle, builder, createUserIdGetter.invoke(builder));
            builder = invokeBuilder(isRemovedHandle, builder, false);
            E entity = buildFunction.apply(builder);
            return ObjectTools.JSRValidate(entity);
        } catch (Throwable e) {
            if (className.endsWith("AggregateBuilder")) {
                throw new AggregateCreateException(e.getMessage(), e);
            } else if (className.endsWith("EntityBuilder")) {
                throw new EntityCreateException(e.getMessage(), e);
            } else {
                throw new EntityException(e.getMessage(), e);
            }
        }
    }

    static String id(String className) {
        if (className.endsWith("AggregateBuilder")) {
            className = className.substring(0, className.length() - "AggregateBuilder".length());
        } else if (className.endsWith("EntityBuilder")) {
            className = className.substring(0, className.length() - "EntityBuilder".length());
        } else {
            throw new EntityException("领域实体类名必须以Entity或Aggregate结尾");
        }
        return className.substring(0, 1).toLowerCase() + className.substring(1) + "Id";
    }

    @SuppressWarnings("unchecked")
    static <B> B invokeBuilder(MethodHandle handle, B builder, Object arg) throws Throwable {
        return (B) handle.invoke(builder, arg);
    }

    Entity validate();
}
