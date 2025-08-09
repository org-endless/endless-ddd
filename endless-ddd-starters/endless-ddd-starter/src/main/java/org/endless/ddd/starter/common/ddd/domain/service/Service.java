package org.endless.ddd.starter.common.ddd.domain.service;

import org.endless.ddd.starter.common.ddd.domain.entity.Aggregate;

/**
 * Service
 * <p>领域服务
 * <p>DDD领域层
 * <p>用于处理多聚合的协作逻辑，无状态，不依赖于任何外部资源，只依赖于聚合根的状态
 * <p>
 * create 2024/02/11 22:04
 * <p>
 * update 2024/08/30 09:04
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface Service<A extends Aggregate> {

}
