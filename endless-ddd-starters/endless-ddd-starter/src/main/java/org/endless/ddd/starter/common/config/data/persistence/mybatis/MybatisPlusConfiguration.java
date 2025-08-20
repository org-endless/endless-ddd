package org.endless.ddd.starter.common.config.data.persistence.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.endless.ddd.starter.common.config.data.persistence.mybatis.bulk.MapperBulkTemplate;
import org.endless.ddd.starter.common.config.data.persistence.mybatis.handler.MybatisPlusMetaObjectHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Import;

/**
 * MybatisPlusConfiguration
 * <p>
 * create 2024/11/10 05:13
 * <p>
 * update 2024/11/10 05:13
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@ConditionalOnClass(MetaObjectHandler.class)
@Import({MybatisPlusMetaObjectHandler.class, MapperBulkTemplate.class})
public class MybatisPlusConfiguration {

}
