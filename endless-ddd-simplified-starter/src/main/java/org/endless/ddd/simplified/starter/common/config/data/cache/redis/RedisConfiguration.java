package org.endless.ddd.simplified.starter.common.config.data.cache.redis;

import org.endless.ddd.simplified.starter.common.config.data.cache.redis.serializer.FastJson2JsonRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConfiguration
 * <p>
 * create 2024/11/07 10:41
 * <p>
 * update 2024/11/07 10:41
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@ConditionalOnProperty(name = "spring.cache.type", havingValue = "redis")
public class RedisConfiguration {

    @ConditionalOnMissingBean
    public @Bean RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory, FastJson2JsonRedisSerializer<Object> redisSerializer) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(redisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(redisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    public @Bean FastJson2JsonRedisSerializer<Object> fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<>(Object.class);
    }
}
