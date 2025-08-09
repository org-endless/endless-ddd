package org.endless.ddd.generator.components.generator.context.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.ddd.generator.common.model.infrastructure.data.mapper.DDDGeneratorMapper;
import org.endless.ddd.generator.components.generator.context.infrastructure.data.record.ContextRecord;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * ContextMapper
 * <p>限界上下文聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see DDDGeneratorMapper
 * @since 1.0.0
 */
@Lazy
@Mapper
public interface ContextMapper extends DDDGeneratorMapper<ContextRecord> {

    default List<ContextRecord> findSimpleProfilesByServiceId(String serviceId) {
        QueryWrapper<ContextRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(ContextRecord::getContextId, ContextRecord::getName)
                .eq(ContextRecord::getServiceId, serviceId)
                .orderByAsc(ContextRecord::getContextId);
        return findAllByWrapper(queryWrapper);
    }
}
