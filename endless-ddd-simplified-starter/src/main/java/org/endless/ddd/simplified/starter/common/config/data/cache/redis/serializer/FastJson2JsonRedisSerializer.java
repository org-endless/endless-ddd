package org.endless.ddd.simplified.starter.common.config.data.cache.redis.serializer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.config.endless.EndlessAutoConfiguration;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.manager.DataManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.nio.charset.Charset;

/**
 * FastJsonRedisSerializer
 * <p>
 * create 2024/11/07 10:59
 * <p>
 * update 2024/11/07 10:59
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Slf4j
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    private EndlessAutoConfiguration configuration;

    private final Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) {
        try {
            if (t == null) {
                return new byte[0];
            }
            log.trace(" Redis 序列化对象：{}", t);
            return JSON.toJSONString(t, filter(), JSONWriter.Feature.PrettyFormat).getBytes(charset());
        } catch (Exception e) {
            throw new DataManagerException(" Redis 序列化对象异常：" + e.getMessage(), e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) {
        try {
            if (bytes == null || bytes.length == 0) {
                return null;
            }
            String string = new String(bytes, charset());
            log.trace(" Redis 反序列化对象：{}", string);
            return JSON.parseObject(string, clazz, filter());
        } catch (Exception e) {
            throw new DataManagerException(" Redis 反序列化对象异常：" + e.getMessage(), e);
        }
    }

    private Filter filter() {
        return JSONReader.autoTypeFilter(configuration.jsonAllowedTypes());
    }

    private Charset charset() {
        return configuration.charset();
    }

    @Autowired
    private void setConfiguration(EndlessAutoConfiguration configuration) {
        this.configuration = configuration;
    }
}
