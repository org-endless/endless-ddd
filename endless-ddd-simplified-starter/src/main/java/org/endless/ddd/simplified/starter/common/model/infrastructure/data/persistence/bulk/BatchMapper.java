package com.tansun.atp.starter.common.model.infrastructure.data.persistence.bulk;

import com.tansun.atp.starter.common.model.domain.entity.Entity;
import com.tansun.atp.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;

/**
 * BatchMapper
 * <p>
 * create 2024/11/10 14:28
 * <p>
 * update 2024/11/10 14:28
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface BatchMapper<R extends DataRecord<? extends Entity>> {

    void save(List<R> records);

    void remove(List<R> records);

    void modify(List<R> records);
}
