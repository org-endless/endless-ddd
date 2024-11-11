package org.endless.ddd.simplified.starter.common.config.rest.converter;

import com.alibaba.fastjson2.JSON;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * FastJsonHttpMessageConverter
 * <p>
 * create 2024/11/09 19:28
 * <p>
 * update 2024/11/09 19:28
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public FastJsonHttpMessageConverter() {
        super(MediaType.APPLICATION_JSON);
    }

    @Override
    protected boolean supports(@NotNull Class<?> clazz) {
        return true;
    }

    @Override
    protected @NotNull Object readInternal(@NotNull Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(inputMessage.getBody(), clazz);
    }

    @Override
    protected void writeInternal(@NotNull Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String json = JSON.toJSONString(object);
        outputMessage.getBody().write(json.getBytes(StandardCharsets.UTF_8));
    }
}
