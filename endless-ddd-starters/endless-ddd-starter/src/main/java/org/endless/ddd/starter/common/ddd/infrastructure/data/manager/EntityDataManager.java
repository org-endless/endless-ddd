package org.endless.ddd.starter.common.ddd.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.application.query.anticorruption.QueryRepository;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.ddd.infrastructure.data.record.DataRecord;

/**
 * DataManager
 * <p>实体数据仓储管理类
 * <p>DDD基础设施层
 * <p>用于处理数据仓储查询逻辑，配合查询模型使用
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 18:59
 *
 * @author Deng Haozhi
 * @see QueryRepository
 * @see DataManager
 * @since 1.0.0
 */
public interface EntityDataManager<R extends DataRecord<E>, E extends Entity>
        extends QueryRepository<E>, DataManager<R> {

}
