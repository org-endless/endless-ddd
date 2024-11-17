package org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.page;

import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;

import java.util.List;

/**
 * PageCallback
 * <p>
 * create 2024/09/12 08:51
 * <p>
 * update 2024/09/12 08:51
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@FunctionalInterface
public interface PageCallback<R extends DataRecord<? extends Entity>> {

    List<R> execute();
}
