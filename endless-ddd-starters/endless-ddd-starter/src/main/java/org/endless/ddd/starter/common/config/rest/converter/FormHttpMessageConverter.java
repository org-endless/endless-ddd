package org.endless.ddd.starter.common.config.rest.converter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.TypeReference;
import com.alibaba.fastjson2.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.exception.config.rest.RestFailedException;
import org.endless.ddd.starter.common.utils.model.json.JsonTools;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.lang.NonNull;

import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static org.endless.ddd.starter.common.config.endless.constant.EndlessConstant.JSON_ALLOWED_TYPES;

/**
 * FormHttpMessageConverter
 * <p>
 * create 2025/01/17 16:41
 * <p>
 * update 2025/01/17 16:42
 *
 * @author Deng Haozhi
 * @see AbstractHttpMessageConverter
 * @since 1.0.0
 */
@Slf4j
public class FormHttpMessageConverter<T> extends AbstractHttpMessageConverter<T> {

    private final Charset charset;

    public FormHttpMessageConverter(EndlessProperties properties) {
        super(MediaType.APPLICATION_FORM_URLENCODED);
        this.charset = properties.charset().getCharset();
    }

    @Override
    protected boolean supports(@NonNull Class<?> clazz) {
        return true;
    }

    @Override
    protected @NonNull T readInternal(@NonNull Class<? extends T> clazz, @NonNull HttpInputMessage inputMessage) {
        try (InputStream inputStream = inputMessage.getBody()) {
            byte[] buffer = inputStream.readAllBytes();
            String formString = URLDecoder.decode(new String(buffer, charset), charset);
            Map<String, String> result = new HashMap<>();
            String[] pairs = formString.split("&");
            for (String pair : pairs) {
                if (pair.isEmpty()) {
                    continue;
                }
                String[] keyValue = pair.split("=", 2);
                String key = keyValue.length > 0 ? keyValue[0] : "";
                String value = keyValue.length > 1 ? keyValue[1] : "";
                result.put(key, value);
            }
            log.trace("[Rest反序列化对象]: {}", JsonTools.maskSensitive(result.toString().replaceAll("[\\r\\n\\s]", "")));
            if (Map.class.isAssignableFrom(clazz)) {
                return clazz.cast(result);
            }
            return JSON.parseObject(JSON.toJSONString(result), clazz, filter());
        } catch (Exception e) {
            throw new RestFailedException("表单数据反序列化对象异常: " + e.getMessage(), e);
        }
    }

    @Override
    protected void writeInternal(@NonNull T t, @NonNull HttpOutputMessage outputMessage) {
        try {
            StringBuilder builder = new StringBuilder();
            Map<String, Object> map = JSON.parseObject(JSON.toJSONString(t, filter(), JSONWriter.Feature.PrettyFormat), new TypeReference<>() {
            });
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!builder.isEmpty()) {
                    builder.append("&");
                }
                String encodedKey = URLEncoder.encode(entry.getKey(), charset);
                String encodedValue = URLEncoder.encode(String.valueOf(entry.getValue()), charset);
                builder.append(encodedKey).append("=").append(encodedValue);
            }
            String json = JSON.toJSONString(t, filter(), JSONWriter.Feature.PrettyFormat);
            log.trace("[Rest序列化对象]: {}", JsonTools.maskSensitive(json.replaceAll("[\\r\\n\\s]", "")));
            outputMessage.getBody().write(builder.toString().getBytes(charset));
        } catch (Exception e) {
            throw new RestFailedException("表单数据序列化对象异常: " + e.getMessage(), e);
        }
    }

    private Filter filter() {
        return JSONReader.autoTypeFilter(JSON_ALLOWED_TYPES);
    }
}
