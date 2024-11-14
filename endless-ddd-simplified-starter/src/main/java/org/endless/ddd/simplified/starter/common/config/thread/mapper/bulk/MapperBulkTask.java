package org.endless.ddd.simplified.starter.common.config.thread.mapper.bulk;

import org.endless.ddd.simplified.starter.common.config.thread.result.AsyncResult;
import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.concurrent.CompletableFuture;

/**
 * MapperBulkTask
 * <p>
 * create 2024/11/10 14:28
 * <p>
 * update 2024/11/10 14:28
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface MapperBulkTask<R extends DataRecord<? extends Entity>> {

    CompletableFuture<AsyncResult<R>> save(R records);

    CompletableFuture<AsyncResult<R>> remove(R records);

    CompletableFuture<AsyncResult<R>> modify(R records);
}
