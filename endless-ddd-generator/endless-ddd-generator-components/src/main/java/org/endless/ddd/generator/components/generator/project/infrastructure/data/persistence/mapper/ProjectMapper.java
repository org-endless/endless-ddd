package org.endless.ddd.generator.components.generator.project.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.ddd.generator.common.model.infrastructure.data.mapper.DDDGeneratorMapper;
import org.endless.ddd.generator.components.generator.project.infrastructure.data.record.ProjectRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ProjectMapper
 * <p>项目聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/08/02 20:02
 * <p>
 * update 2025/08/02 20:02
 *
 * @author Deng Haozhi
 * @see DDDGeneratorMapper
 * @since 1.0.0
 */
@Lazy
@Mapper
public interface ProjectMapper extends DDDGeneratorMapper<ProjectRecord> {

    default List<ProjectRecord> findSimpleProfilesByIds(List<String> projectIds) {
        QueryWrapper<ProjectRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(ProjectRecord::getProjectId, ProjectRecord::getName)
                .in(!CollectionUtils.isEmpty(projectIds), ProjectRecord::getProjectId, projectIds)
                .orderByAsc(ProjectRecord::getProjectId);
        return findAllByWrapper(queryWrapper);
    }
}
