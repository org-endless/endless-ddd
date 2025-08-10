package org.endless.ddd.starter.common.config.data.cache.redis.stream.listener.task;

import org.endless.ddd.starter.common.config.data.cache.redis.serializer.FastJson2JsonRedisSerializer;
import org.endless.ddd.starter.common.config.data.cache.redis.stream.listener.RedisStreamListener;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * RedisStreamListenerTaskImpl
 * <p>
 * create 2025/07/10 05:37
 * <p>
 * update 2025/07/10 05:37
 * update 2025/07/10 05:37
 *
 * @author Deng Haozhi
 * @see RedisStreamListenerTask
 * @since 1.0.0
 */
public class RedisStreamListenerTaskImpl implements RedisStreamListenerTask {

    private final RedisTemplate<String, Object> redisTemplate;

    private final EndlessProperties properties;

    public RedisStreamListenerTaskImpl(RedisTemplate<String, Object> redisTemplate, EndlessProperties properties) {
        this.redisTemplate = redisTemplate;
        this.properties = properties;
    }

    @Override
    public <T> void execute(RedisStreamListener<T> redisStreamListener, MapRecord<String, String, String> record, String streamKey, String group) {
        FastJson2JsonRedisSerializer<T> serializer = new FastJson2JsonRedisSerializer<>(properties, redisStreamListener.getPayloadClass());
        T payload = serializer.deserialize(record.getValue().get("payload").getBytes());
        redisStreamListener.execute(payload);
        redisTemplate.opsForStream().acknowledge(streamKey, group, record.getId());
        redisTemplate.opsForStream().delete(streamKey, record.getId());
    }
}
