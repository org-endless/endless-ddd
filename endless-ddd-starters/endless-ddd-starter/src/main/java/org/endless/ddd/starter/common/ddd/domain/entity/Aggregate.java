package org.endless.ddd.starter.common.ddd.domain.entity;

/**
 * Aggregate
 * <p>聚合
 * <p>DDD领域层
 * <p>领域核心实体类，实例化为聚合根
 * <p>用于处理领域内部逻辑，统一管理领域内部的实体，是领域模型的唯一入口
 * <p>为简化建模，本框架领域只支持单个聚合根
 * <p>
 * create 2024/02/6 22:21
 * <p>
 * update 2024/09/05 09:19
 *
 * @author Deng Haozhi
 * @see Entity
 * @since 1.0.0
 */
public interface Aggregate extends Entity {

}
