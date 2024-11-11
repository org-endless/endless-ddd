package org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.bulk;


import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;

/**
 * MybatisPlusBulkTemplate
 * <p>
 * create 2024/11/10 14:48
 * <p>
 * update 2024/11/10 14:48
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class MybatisPlusBulkTemplate<R extends DataRecord<? extends Entity>> implements MybatisPlusBulkOperations<R> {

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
