package org.endless.ddd.generator.components.generator.project.infrastructure.adapter.project.spring;

import freemarker.template.Configuration;
import org.endless.ddd.generator.common.model.infrastructure.adapter.DDDGeneratorContentDrivenAdapter;
import org.endless.ddd.generator.common.model.infrastructure.adapter.DDDGeneratorFileDrivenAdapter;
import org.endless.ddd.generator.components.generator.project.domain.anticorruption.ProjectDrivenAdapter;
import org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SpringProjectDrivenAdapter
 * <p>
 * create 2025/07/29 21:14
 * <p>
 * update 2025/07/29 21:14
 *
 * @author Deng Haozhi
 * @see ProjectDrivenAdapter
 * @since 1.0.0
 */
@Lazy
@Component
public class SpringProjectDrivenAdapter implements ProjectDrivenAdapter, DDDGeneratorContentDrivenAdapter, DDDGeneratorFileDrivenAdapter {

    private final Configuration freemarkerConfig;

    public SpringProjectDrivenAdapter(Configuration freemarkerConfig) {
        this.freemarkerConfig = freemarkerConfig;
    }


    @Override
    public void generate(ProjectAggregate aggregate) {
        // List<String> serviceArtifactIds = serviceDrivingAdapter.findSimpleProfilesByProjectId(ServiceFindByProjectIdReqQTransfer.builder()
        //                 .projectId(aggregate.getProjectId())
        //                 .build().validate())
        //         .validate().simpleProfiles().stream()
        //         .map(ServiceFindSimpleProfileRespQTransfer::serviceId).toList();
        // pom(aggregate, serviceArtifactIds);
    }

    private void pom(ProjectAggregate aggregate, List<String> serviceArtifactIds) {
        Map<String, Object> model = new HashMap<>();
        model.put("project", aggregate);
        model.put("serviceArtifactIds", serviceArtifactIds);
        String content = DDDGeneratorContentDrivenAdapter.super.freemarker(freemarkerConfig, model, "project/ProjectPom.ftl");
        if (StringUtils.hasText(content)) {
            write(aggregate.getRootPath(), "pom.xml", content);
        }
    }
}
