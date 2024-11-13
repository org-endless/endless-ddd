package org.endless.ddd.simplified.starter.common.config.rest.converter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.config.endless.EndlessAutoConfiguration;
import org.endless.ddd.simplified.starter.common.exception.sidecar.rest.RestErrorException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * FastJson2HttpMessageConverter
 * <p>
 * create 2024/11/09 19:28
 * <p>
 * update 2024/11/09 19:28
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Slf4j
public class FastJson2HttpMessageConverter<T> extends AbstractHttpMessageConverter<T> {

    private EndlessAutoConfiguration configuration;


    public FastJson2HttpMessageConverter() {
        super(MediaType.APPLICATION_JSON);
    }

    @Override
    protected boolean supports(@NotNull Class<?> clazz) {
        return true;
    }

    @Override
    protected @NotNull T readInternal(@NotNull Class<? extends T> clazz, @NotNull HttpInputMessage inputMessage) {
        try (InputStream inputStream = inputMessage.getBody()) {
            // 使用缓冲区读取 InputStream 内容
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, length);
            }
            // 转换为字符串
            String string = byteArrayOutputStream.toString(charset());
            log.trace("Rest 反序列化对象: {}", string);
            return JSON.parseObject(string, clazz, filter());
        } catch (Exception e) {
            throw new RestErrorException(" Rest 反序列化对象异常: " + e.getMessage(), e);
        }
    }

    @Override
    protected void writeInternal(@NotNull T t, @NotNull HttpOutputMessage outputMessage) {
        try {
            String json = JSON.toJSONString(t, filter(), JSONWriter.Feature.PrettyFormat);
            log.trace("Rest 序列化对象: {}", json);
            outputMessage.getBody().write(json.getBytes(charset()));
        } catch (Exception e) {
            throw new RestErrorException(" Rest 序列化对象异常: " + e.getMessage(), e);
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
