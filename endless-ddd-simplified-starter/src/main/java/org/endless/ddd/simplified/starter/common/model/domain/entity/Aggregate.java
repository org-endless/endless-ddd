package org.endless.ddd.simplified.starter.common.model.domain.entity;

import java.io.Serializable;

/**
 * Aggregate
 * <p>聚合模型
 * <p>DDD领域层
 * <p>领域核心实体类，实例化为聚合根
 * <p>处理聚合内部逻辑，统一管理聚合内部的实体、值对象
 * <p>
 * create 2024/02/6 22:21
 * <p>
 * update 2024/09/05 09:19
 *
 * @author Deng Haozhi
 * @see Entity
 * @since 1.0.0
 */
public interface Aggregate extends Serializable, Entity {

}
