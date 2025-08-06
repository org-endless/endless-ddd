package org.endless.ddd.starter.common.model.infrastructure.data.manager;

import org.endless.ddd.starter.common.model.domain.anticorruption.Repository;
import org.endless.ddd.starter.common.model.domain.entity.Entity;
import org.endless.ddd.starter.common.model.infrastructure.data.record.DataRecord;

/**
 * DataManager
 * <p>DDD数据仓储管理类型模版
 * <p>工厂模式处理数据仓储逻辑
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
