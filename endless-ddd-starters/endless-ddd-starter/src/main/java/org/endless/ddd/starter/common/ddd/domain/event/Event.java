package org.endless.ddd.starter.common.ddd.domain.event;

import org.endless.ddd.starter.common.ddd.domain.entity.Aggregate;

/**
 * Event
 * <p>领域事件
 * <p>DDD领域层
 * <p>用于发布领域模型事件，触发领域外部逻辑调用，依赖领域聚合模型
 * <p>
 * create 2024/09/06 13:29
 * <p>
 * update 2024/09/06 13:29
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface Event<A extends Aggregate> {

}
