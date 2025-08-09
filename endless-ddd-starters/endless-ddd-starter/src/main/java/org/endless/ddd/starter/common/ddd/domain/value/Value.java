package org.endless.ddd.starter.common.ddd.domain.value;

/**
 * Value
 * <p>值对象
 * <p>DDD领域层
 * <p>用于组合领域模型中的一系列相关联的属性，这些属性生命周期相同
 * <p>为简化建模，值对象与实体之间是一对一的关系
 * <p>
 * create 2024/02/11 22:00
 * <p>
 * update 2024/08/30 09:04
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface Value {

    Value validate();
}
