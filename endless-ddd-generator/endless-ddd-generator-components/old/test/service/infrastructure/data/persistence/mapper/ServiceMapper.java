package org.endless.ddd.generator.components.generator.service.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.components.generator.service.infrastructure.data.record.*;
import org.springframework.context.annotation.Lazy;

/**
 * ServiceMapper
 * <p>服务聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/08/05 22:32
 * <p>
 * update 2025/08/05 22:32
 *
 * @author Deng Haozhi
 * @see DDDGeneratorMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface ServiceMapper extends DDDGeneratorMapper<ServiceRecord> {

}
