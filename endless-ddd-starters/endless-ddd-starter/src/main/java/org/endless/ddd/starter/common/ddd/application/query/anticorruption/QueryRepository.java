package org.endless.ddd.starter.common.ddd.application.query.anticorruption;

import org.endless.ddd.starter.common.ddd.domain.entity.Entity;

/**
 * QueryRepository
 * <p>CQRS查询仓储适配器
 * <p>DDD应用层
 * <p>用于处理数据仓储查询，不受到领域模型和状态的限制
 * <p>根据领域实体单独创建
 * <p>
 * create 2024/11/03 18:35
 * <p>
 * update 2024/11/03 18:35
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface QueryRepository<E extends Entity> {

}
