package org.endless.ddd.simplified.starter.common.model.domain.anticorruption;

import org.endless.ddd.simplified.starter.common.model.domain.entity.Aggregate;

import java.util.Optional;

/**
 * Repository
 * <p>仓储适配器模版
 * <p>DDD领域防腐层
 * <p>处理数据存储接口
 * <p>
 * create 2024/02/06 18:47
 * <p>
 * update 2024/11/03 19:15
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface Repository<A extends Aggregate> {

    A save(A aggregate);
    void remove(A aggregate);
    A modify(A aggregate);
    Optional<A> findById(String id);

    Optional<A> findByIdForUpdate(String id);




}
