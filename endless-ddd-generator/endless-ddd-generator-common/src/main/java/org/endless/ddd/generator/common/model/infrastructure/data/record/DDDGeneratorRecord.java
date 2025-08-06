package org.endless.ddd.generator.common.model.infrastructure.data.record;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorEntity;
import org.endless.ddd.starter.common.model.infrastructure.data.record.DataRecord;

/**
 * DDDGeneratorRecord
 * <p>
 * create 2024/09/03 11:34
 * <p>
 * update 2024/09/03 12:10
 *
 * @author Deng Haozhi
 * @see DataRecord
 * @since 1.0.0
 */
public interface DDDGeneratorRecord<E extends DDDGeneratorEntity>
        extends DataRecord<E> {

}
