package org.endless.ddd.starter.common.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.domain.anticorruption.Repository;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.ddd.infrastructure.data.record.DataRecord;

/**
 * DataManager
 * <p>数据仓储管理类
 * <p>DDD基础设施层
 * <p>用于处理数据仓储逻辑，可实现持久化和缓存等不同策略
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/05 09:18
 *
 * @author Deng Haozhi
 * @see Repository
 * @since 1.0.0
 */
public interface DataManager<R extends DataRecord<? extends Entity>> {

}
