package org.endless.ddd.simplified.starter.common.config.thread.mapper.bulk;


import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.config.thread.result.AsyncResult;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperSaveException;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperSaveFailedException;
import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * MapperBulkTemplate
 * <p>
 * create 2024/11/10 14:48
 * <p>
 * update 2024/11/10 14:48
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class MapperBulkTemplate<R extends DataRecord<? extends Entity>> implements MapperBulkOperations<R> {

    private final MapperBulkTask<R> task;

    public MapperBulkTemplate(MapperBulkTask<R> task) {
        this.task = task;
    }


    @Override
    @Log(message = "数据库异步批量存入", value = "#record", level = LogLevel.TRACE)
    public List<AsyncResult<R>> save(List<R> records) {
        Optional.ofNullable(records)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new MapperSaveFailedException("要存入的数据库记录列表不能为空"));

        try {
            List<CompletableFuture<AsyncResult<R>>> futures = records.stream()
                    .map(task::save)
                    .toList();
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            return futures.stream()
                    .map(CompletableFuture::join)
                    .toList();
        } catch (CompletionException e) {
            throw new MapperSaveException("数据库异步批量存入异常: " + e.getCause().getMessage(), e.getCause());
        }
    }

    @Override
    @Log(message = "数据库异步批量删除", value = "#record", level = LogLevel.TRACE)
    public List<AsyncResult<R>> remove(List<R> records) {
        return List.of();
    }

    @Override
    @Log(message = "数据库异步批量修改", value = "#record", level = LogLevel.TRACE)
    public List<AsyncResult<R>> modify(List<R> records) {
        return List.of();
    }
}
