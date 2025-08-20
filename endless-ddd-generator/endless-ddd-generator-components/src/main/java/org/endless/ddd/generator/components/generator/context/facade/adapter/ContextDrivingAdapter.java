package org.endless.ddd.generator.components.generator.context.facade.adapter;

import org.endless.ddd.generator.common.model.facade.adapter.DDDGeneratorDrivingAdapter;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransferReq;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextModifyReqCTransferReq;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextRemoveReqCTransferReq;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindByServiceIdReqQTransferReq;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfilesRespQTransferReq;

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

    void create(ContextCreateReqCTransferReq command);

    void remove(ContextRemoveReqCTransferReq command);

    void modify(ContextModifyReqCTransferReq command);

    ContextFindSimpleProfilesRespQTransferReq findSimpleProfilesByServiceId(ContextFindByServiceIdReqQTransferReq query);
}
