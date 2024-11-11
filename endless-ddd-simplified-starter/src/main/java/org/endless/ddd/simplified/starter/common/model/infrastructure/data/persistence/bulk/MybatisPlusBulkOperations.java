package com.tansun.atp.starter.common.model.infrastructure.data.persistence.bulk;

import com.tansun.atp.starter.common.model.domain.entity.Entity;
import com.tansun.atp.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;

/**
 * MybatisPlusBulkOperations
 * <p>
 * create 2024/11/10 14:45
 * <p>
 * update 2024/11/10 14:45
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface MybatisPlusBulkOperations<R extends DataRecord<? extends Entity>> {

    public void save(List<R> records);

    public void remove(List<R> records);

    public void modify(List<R> records);
}
