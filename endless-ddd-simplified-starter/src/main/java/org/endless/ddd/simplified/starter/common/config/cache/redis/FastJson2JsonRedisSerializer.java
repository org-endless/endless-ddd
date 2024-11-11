package org.endless.ddd.simplified.starter.common.config.cache.redis;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static final String[] JSON_WHITELIST = {"com.endless"};

    static final Filter JSON_TYPE_FILTER = JSONReader.autoTypeFilter(JSON_WHITELIST);

    private final Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        log.trace("序列化对象：{}", t);
        return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        String string = new String(bytes, DEFAULT_CHARSET);
        log.trace("反序列化对象：{}", string);
        return JSON.parseObject(string, clazz, JSON_TYPE_FILTER);
    }
}
