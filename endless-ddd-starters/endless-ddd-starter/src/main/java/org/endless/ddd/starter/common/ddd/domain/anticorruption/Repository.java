package org.endless.ddd.starter.common.ddd.domain.anticorruption;

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

    A save(A aggregate);

    void remove(A aggregate);

    A modify(A aggregate);

    Optional<A> findById(String id);

    Optional<A> findByIdForUpdate(String id);

}
