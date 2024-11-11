package org.endless.ddd.simplified.starter.common.model.domain.service;

import org.endless.ddd.simplified.starter.common.model.domain.entity.Aggregate;

/**
 * Service
 * <p>DDD领域服务类型模版
 * <p>处理跨聚合逻辑，无状态，不依赖于任何外部资源，只依赖于聚合根的状态
 * <p>
 * create 2024/02/11 22:04
 * <p>
 * update 2024/08/30 09:04
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface Service<A extends Aggregate> {

}
