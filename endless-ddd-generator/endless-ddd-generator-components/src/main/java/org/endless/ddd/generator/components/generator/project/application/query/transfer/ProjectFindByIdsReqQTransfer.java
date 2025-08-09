package org.endless.ddd.generator.components.generator.project.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.query.transfer.DDDGeneratorQueryTransfer;

import java.util.List;

/**
 * ProjectFindByIdsReqQTransfer
 * <p>项目根据ID列表查询请求传输对象
 * <p>
 * create 2025/08/05 23:11
 * <p>
 * update 2025/08/05 23:11
 *
 * @param projectIds 项目ID列表
 * @author Deng Haozhi
 * @see DDDGeneratorQueryTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"projectIds"})
public record ProjectFindByIdsReqQTransfer(List<String> projectIds) implements DDDGeneratorQueryTransfer {

    @Override
    public ProjectFindByIdsReqQTransfer validate() {
        return this;
    }
}
