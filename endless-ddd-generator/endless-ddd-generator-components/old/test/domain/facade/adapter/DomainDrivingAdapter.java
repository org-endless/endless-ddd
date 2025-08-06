package org.endless.ddd.generator.components.generator.domain.facade.adapter;

import org.endless.ddd.generator.common.model.facade.adapter.DDDGeneratorDrivingAdapter;
import org.endless.ddd.generator.components.generator.domain.application.command.transfer.DomainCreateReqCTransfer;

/**
 * DomainDrivingAdapter
 * <p>
 * 领域主动适配器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivingAdapter
 * @since 0.0.1
 */
public interface DomainDrivingAdapter extends DDDGeneratorDrivingAdapter {

    void create(DomainCreateReqCTransfer command);
}
