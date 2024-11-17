package org.endless.ddd.simplified.starter.common.config.thread.mapper.bulk;

import org.endless.ddd.simplified.starter.common.config.thread.result.AsyncResult;
import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;

/**
 * MapperBulkOperations
 * <p>
 * create 2024/11/10 14:45
 * <p>
 * update 2024/11/10 14:45
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface MapperBulkOperations<R extends DataRecord<? extends Entity>> {

    List<AsyncResult<R>> save(List<R> records);

    List<AsyncResult<R>> remove(List<R> records);

    List<AsyncResult<R>> modify(List<R> records);
}
