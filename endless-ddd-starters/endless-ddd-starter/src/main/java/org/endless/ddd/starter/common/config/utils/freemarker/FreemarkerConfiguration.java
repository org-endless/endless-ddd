package org.endless.ddd.starter.common.config.utils.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;

import java.nio.charset.Charset;

/**
 * FreemarkerConfiguration
 * <p>
 * create 2025/07/30 21:33
 * <p>
 * update 2025/07/30 21:33
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@ConditionalOnProperty(name = "spring.freemarker.enabled", havingValue = "true", matchIfMissing = true)
public class FreemarkerConfiguration {

    private final Environment environment;

    private final Charset charset;

    public FreemarkerConfiguration(Environment environment, EndlessProperties properties) {
        this.environment = environment;
        this.charset = properties.charset().getCharset();
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean BeanPostProcessor freemarkerConfigCustomizer() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
                if (bean instanceof Configuration && "freeMarkerConfiguration".equals(beanName)) {
                    ((Configuration) bean).setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                    ((Configuration) bean).setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                    ((Configuration) bean).setDefaultEncoding(environment.getProperty("spring.freemarker.charset", charset.name()));
                    ((Configuration) bean).setClassForTemplateLoading(this.getClass(),
                            environment.getProperty("spring.freemarker.template-loader-path", "classpath:/templates/freemarker"));
                }
                return bean;
            }
        };
    }
}
