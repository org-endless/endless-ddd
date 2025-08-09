package org.endless.ddd.generator.components.generator.service.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.generator.common.model.application.query.handler.DDDGeneratorQueryHandler;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindByProjectIdReqQTransfer;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindSimpleProfilesRespQTransfer;

/**
 * ServiceQueryHandler
 * <p>
 * 服务领域查询处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorQueryHandler
 * @since 1.0.0
 */
public interface ServiceQueryHandler extends DDDGeneratorQueryHandler {

    ServiceFindSimpleProfilesRespQTransfer findSimpleProfilesByProjectId(
            @NotNull(message = "根据项目ID查询项目基本信息列表请求对象不能为空")
            @Valid ServiceFindByProjectIdReqQTransfer query
    );
}
