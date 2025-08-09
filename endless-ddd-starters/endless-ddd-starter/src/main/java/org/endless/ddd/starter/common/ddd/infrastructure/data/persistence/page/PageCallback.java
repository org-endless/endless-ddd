package org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.page;

import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.ddd.infrastructure.data.record.DataRecord;

import java.util.List;

/**
 * PageCallback
 * <p>分页回调接口
 * <p>
 * create 2024/09/12 08:51
 * <p>
 * update 2024/09/12 08:51
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@FunctionalInterface
public interface PageCallback<R extends DataRecord<? extends Entity>> {

    List<R> execute();
}
