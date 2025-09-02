package org.endless.ddd.starter.common.ddd.domain.anticorruption;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.ddd.domain.entity.Aggregate;

import java.util.Optional;

/**
 * Repository
 * <p>仓储
 * <p>DDD领域层防腐
 * <p>用于处理数据仓储，依赖领域聚合模型
 * <p>
 * create 2024/02/06 18:47
 * <p>
 * update 2024/11/03 19:15
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface Repository<A extends Aggregate> {

    void save(
            @NotNull(message = "保存聚合根数据不能为空")
            @Valid A aggregate);

    void remove(
            @NotNull(message = "删除聚合根数据不能为空")
            @Valid A aggregate);

    void modify(
            @NotNull(message = "修改聚合根数据不能为空")
            @Valid A aggregate);

    Optional<A> findById(
            @NotBlank(message = "聚合根ID不能为空") String id);

    Optional<A> findByIdForUpdate(
            @NotBlank(message = "聚合根ID不能为空") String id);
}
