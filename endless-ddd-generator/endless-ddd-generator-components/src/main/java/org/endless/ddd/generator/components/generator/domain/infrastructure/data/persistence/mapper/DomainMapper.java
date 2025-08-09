package org.endless.ddd.generator.components.generator.domain.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.ddd.generator.common.model.infrastructure.data.mapper.DDDGeneratorMapper;
import org.endless.ddd.generator.components.generator.domain.infrastructure.data.record.DomainRecord;
import org.springframework.context.annotation.Lazy;

/**
 * DomainMapper
 * <p>领域聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DDDGeneratorMapper
 * @since 1.0.0
 */
@Lazy
@Mapper
public interface DomainMapper extends DDDGeneratorMapper<DomainRecord> {

}
