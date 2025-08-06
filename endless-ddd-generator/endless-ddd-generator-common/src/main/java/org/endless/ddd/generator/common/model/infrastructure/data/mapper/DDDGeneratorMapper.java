package org.endless.ddd.generator.common.model.infrastructure.data.mapper;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorEntity;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.starter.common.model.infrastructure.data.persistence.mapper.DataMapper;

/**
 * DDDGeneratorMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 1.0.0
 */
public interface DDDGeneratorMapper<R extends DDDGeneratorRecord<? extends DDDGeneratorEntity>>
        extends DataMapper<R> {

}
