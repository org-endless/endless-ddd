package com.tansun.atp.starter.common.config.data.cache;

import com.tansun.atp.starter.common.config.data.cache.redis.RedisConfiguration;
import com.tansun.atp.starter.common.config.data.cache.redis.serializer.FastJson2JsonRedisSerializer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * CacheConfiguration
 * <p>
 * create 2024/11/10 05:49
 * <p>
 * update 2024/11/10 05:49
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@EnableCaching
@Import(RedisConfiguration.class)
public class CacheConfiguration extends CachingConfigurerSupport {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory, FastJson2JsonRedisSerializer<Object> redisSerializer) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(
                        RedisCacheConfiguration.defaultCacheConfig()
                                .disableCachingNullValues()
                                .entryTtl(Duration.ofMinutes(60))
                                .prefixCacheNameWith("atp:")
                                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer)))
                .transactionAware()
                .build();
    }
}
