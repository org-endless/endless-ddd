package org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.bulk;


import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.mapper.Mapper;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;

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
public class BatchMapperExecutor<R extends DataRecord<? extends Entity>> implements BatchMapper<R> {

    private final Mapper<R> mapper;

    public BatchMapperExecutor(Mapper<R> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void save(List<R> records) {
    }

    @Override
    public void remove(List<R> records) {
    }

    @Override
    public void modify(List<R> records) {
    }
}
