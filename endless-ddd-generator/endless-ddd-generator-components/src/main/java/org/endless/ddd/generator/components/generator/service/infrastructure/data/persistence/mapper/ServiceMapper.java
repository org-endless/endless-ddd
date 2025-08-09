package org.endless.ddd.generator.components.generator.service.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.ddd.generator.common.model.infrastructure.data.mapper.DDDGeneratorMapper;
import org.endless.ddd.generator.components.generator.service.infrastructure.data.record.ServiceRecord;
import org.springframework.context.annotation.Lazy;

import java.util.List;

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
 * @since 1.0.0
 */
@Lazy
@Mapper
public interface ServiceMapper extends DDDGeneratorMapper<ServiceRecord> {

    default List<ServiceRecord> findSimpleProfilesByProjectId(String projectId) {
        QueryWrapper<ServiceRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(ServiceRecord::getServiceId, ServiceRecord::getServiceArtifactId, ServiceRecord::getName)
                .eq(ServiceRecord::getProjectId, projectId)
                .orderByAsc(ServiceRecord::getServiceId);
        return findAllByWrapper(queryWrapper);
    }
}
