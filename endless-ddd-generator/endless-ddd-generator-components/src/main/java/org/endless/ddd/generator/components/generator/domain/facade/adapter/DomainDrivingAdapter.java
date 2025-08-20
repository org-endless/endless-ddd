package org.endless.ddd.generator.components.generator.domain.facade.adapter;

import org.endless.ddd.generator.common.model.facade.adapter.DDDGeneratorDrivingAdapter;
import org.endless.ddd.generator.components.generator.domain.application.command.transfer.DomainCreateReqCTransferReq;

/**
 * DomainDrivingAdapter
 * <p>领域领域主动适配器
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivingAdapter
 * @since 1.0.0
 */
public interface DomainDrivingAdapter extends DDDGeneratorDrivingAdapter {

    void create(DomainCreateReqCTransferReq command);

}
