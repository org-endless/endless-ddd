package org.endless.ddd.starter.common.config.data.cache.redis.serializer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.exception.config.redis.RedisSerializerException;
import org.endless.ddd.starter.common.utils.model.json.JsonTools;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.nio.charset.Charset;

import static org.endless.ddd.starter.common.config.endless.constant.EndlessConstant.JSON_ALLOWED_TYPES;

/**
 * FastJsonRedisSerializer
 * <p>
 * create 2024/11/07 10:59
 * <p>
 * update 2024/11/17 15:59
 *
 * @author Deng Haozhi
 * @see RedisSerializer
 * @since 1.0.0
 */
@Slf4j
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    private final Charset charset;

    private final Class<T> clazz;

    public FastJson2JsonRedisSerializer(EndlessProperties properties, Class<T> clazz) {
        this.charset = properties.charset().getCharset();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) {
        try {
            if (t == null) {
                return new byte[0];
            }
            log.trace("[Redis序列化对象]: {}", ObjectTools.maskSensitive(t).replaceAll("[\\r\\n\\s]", ""));
            return JSON.toJSONString(t, filter(), JSONWriter.Feature.PrettyFormat).getBytes(charset);
        } catch (Exception e) {
            throw new RedisSerializerException("Redis序列化对象异常: " + e.getMessage(), e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) {
        try {
            if (bytes == null || bytes.length == 0) {
                return null;
            }
            String string = new String(bytes, charset);
            log.trace("[Redis反序列化对象]: {}", JsonTools.maskSensitive(string.replaceAll("[\\r\\n\\s]", "")));
            return JSON.parseObject(string, clazz, filter());
        } catch (Exception e) {
            throw new RedisSerializerException("Redis反序列化对象异常: " + e.getMessage(), e);
        }
    }

    private Filter filter() {
        return JSONReader.autoTypeFilter(JSON_ALLOWED_TYPES);
    }
}
