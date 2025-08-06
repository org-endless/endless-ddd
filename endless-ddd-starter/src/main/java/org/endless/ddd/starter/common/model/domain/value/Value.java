package org.endless.ddd.starter.common.model.domain.value;

/**
 * Value
 * <p>DDD值对象类型模版
 * <p>同一生命周期的一系列属性，在聚合中使用
 * <p>应该与聚合根是一对一关系
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
