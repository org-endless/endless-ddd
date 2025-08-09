package org.endless.ddd.generator.components.generator.context.facade.adapter;

import org.endless.ddd.generator.common.model.facade.adapter.DDDGeneratorDrivingAdapter;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindByServiceIdReqQTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfilesRespQTransfer;

/**
 * ContextDrivingAdapter
 * <p>限界上下文领域主动适配器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivingAdapter
 * @since 1.0.0
 */
public interface ContextDrivingAdapter extends DDDGeneratorDrivingAdapter {

    void create(ContextCreateReqCTransfer command);

    void remove(ContextRemoveReqCTransfer command);

    void modify(ContextModifyReqCTransfer command);

    ContextFindSimpleProfilesRespQTransfer findSimpleProfilesByServiceId(ContextFindByServiceIdReqQTransfer query);
}
