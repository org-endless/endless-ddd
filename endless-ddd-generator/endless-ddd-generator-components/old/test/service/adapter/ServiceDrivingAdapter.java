package org.endless.ddd.generator.components.generator.service.facade.adapter;

import org.endless.ddd.generator.common.model.facade.adapter.DDDGeneratorDrivingAdapter;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;

/**
 * ServiceDrivingAdapter
 * <p>
 * 服务领域主动适配器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivingAdapter
 * @since 0.0.1
 */
public interface ServiceDrivingAdapter extends DDDGeneratorDrivingAdapter {

    void create(ServiceCreateReqCTransfer command);

    void remove(ServiceRemoveReqCTransfer command);

    void modify(ServiceModifyReqCTransfer command);

    void generate(ServiceGenerateReqCTransfer command);
}
