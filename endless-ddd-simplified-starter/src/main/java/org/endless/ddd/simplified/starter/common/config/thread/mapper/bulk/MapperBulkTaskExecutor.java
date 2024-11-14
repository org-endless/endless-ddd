package org.endless.ddd.simplified.starter.common.config.thread.mapper.bulk;


import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.config.thread.result.AsyncResult;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperModifyFailedException;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperRemoveFailedException;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperSaveFailedException;
import org.endless.ddd.simplified.starter.common.handler.result.type.ServiceStatus;
import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.mapper.Mapper;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

/**
 * BatchMapperExecuter
 * <p>
 * create 2024/11/10 14:33
 * <p>
 * update 2024/11/10 14:33
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class MapperBulkTaskExecutor<R extends DataRecord<? extends Entity>> implements MapperBulkTask<R> {

    private final Mapper<R> mapper;

    public MapperBulkTaskExecutor(Mapper<R> mapper) {
        this.mapper = mapper;
    }

    @Override
    @Async("mapperTaskExecutor")
    @Log(message = "数据库异步存入", value = "#record", level = LogLevel.TRACE)
    public CompletableFuture<AsyncResult<R>> save(R record) {
        try {
            mapper.save(record);
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.SUCCESS).message("数据库异步存入成功").data(record).build());
        } catch (MapperSaveFailedException e) {
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.FAILED).message("数据库异步存入失败: " + e.getMessage()).data(record).build());
        } catch (Exception e) {
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.UNKNOWN).message("数据库异步存入异常，状态未知: " + e.getMessage()).data(record).build());
        }
    }

    @Override
    @Async("mapperTaskExecutor")
    @Log(message = "数据库异步删除", value = "#record", level = LogLevel.TRACE)
    public CompletableFuture<AsyncResult<R>> remove(R record) {
        try {
            mapper.remove(record);
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.SUCCESS).message("数据库异步删除成功").data(record).build());
        } catch (MapperRemoveFailedException e) {
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.FAILED).message("数据库异步删除失败" + e.getMessage()).data(record).build());
        } catch (Exception e) {
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.UNKNOWN).message("数据库异步删除异常，状态未知" + e.getMessage()).data(record).build());
        }
    }

    @Override
    @Async("mapperTaskExecutor")
    @Log(message = "数据库异步修改", value = "#record", level = LogLevel.TRACE)
    public CompletableFuture<AsyncResult<R>> modify(R record) {
        try {
            mapper.modify(record);
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.SUCCESS).message("数据库异步修改成功").data(record).build());
        } catch (MapperModifyFailedException e) {
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.FAILED).message("数据库异步修改失败" + e.getMessage()).data(record).build());
        } catch (Exception e) {
            return CompletableFuture.completedFuture(AsyncResult.<R>builder()
                    .status(ServiceStatus.UNKNOWN).message("数据库异步修改异常，状态未知" + e.getMessage()).data(record).build());
        }
    }
}
