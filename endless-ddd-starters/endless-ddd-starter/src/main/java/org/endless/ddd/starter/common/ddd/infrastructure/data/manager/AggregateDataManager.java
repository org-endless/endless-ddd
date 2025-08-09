package org.endless.ddd.starter.common.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.application.query.anticorruption.QueryRepository;
import org.endless.ddd.starter.common.ddd.domain.anticorruption.Repository;
import org.endless.ddd.starter.common.ddd.domain.entity.Aggregate;
import org.endless.ddd.starter.common.ddd.infrastructure.data.record.DataRecord;

/**
 * DataManager
 * <p>聚合数据仓储管理类
 * <p>DDD基础设施层
 * <p>用于处理数据仓储逻辑，可实现持久化和缓存等不同策略
 * <p>统一处理聚合及子实体的数据仓储逻辑
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 18:58
 *
 * @author Deng Haozhi
 * @see Repository
 * @see QueryRepository
 * @see DataManager
 * @since 1.0.0
 */
public interface AggregateDataManager<R extends DataRecord<A>, A extends Aggregate>
        extends Repository<A>, QueryRepository<A>, DataManager<R> {

}
