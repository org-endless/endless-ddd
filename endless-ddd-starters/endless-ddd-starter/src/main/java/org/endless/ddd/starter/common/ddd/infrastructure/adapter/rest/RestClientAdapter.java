package org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.common.transfer.ReqTransfer;
import org.endless.ddd.starter.common.ddd.common.transfer.RespTransfer;
import org.endless.ddd.starter.common.ddd.domain.anticorruption.DrivenAdapter;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * RestClientAdapter
 * <p>Rest客户端适配器
 * <p>DDD基础设施层
 * <p>用于处理访问外部Rest服务的被动适配器
 * <p>
 * create 2024/09/08 22:30
 * <p>
 * update 2025/01/08 12:44
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface RestClientAdapter extends DrivenAdapter {

    default Optional<byte[]> get(
            @NotNull RestTemplate restTemplate,
            @NotBlank(message = "REST请求URI不能为空") String url,
            HttpHeaders headers) {
        ResponseEntity<byte[]> responseEntity;
        try {
            responseEntity = restTemplate.exchange(
                    new URI(url),
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<byte[]>() {
                    }
            );
        } catch (URISyntaxException e) {
            throw new DrivenAdapterFailedException(e);
        }
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new DrivenAdapterFailedException("被动适配器服务返回异常状态码: " + responseEntity.getStatusCode());
        }
        return Optional.ofNullable(responseEntity.getBody());
    }


    default <S extends ReqTransfer, R extends RespTransfer> Optional<R> post(
            @NotNull RestClient restClient,
            @NotBlank(message = "REST请求URI不能为空") String uri,
            @Valid S request,
            Class<R> responseClass,
            Consumer<HttpHeaders> headers) {
        return Optional.ofNullable(Optional.ofNullable(restClient.post()
                        .uri(uri)
                        .headers(headers)
                        .body(request)
                        .retrieve()
                        .body(new ParameterizedTypeReference<RestResponse<R>>() {
                        }))
                .orElseThrow(() -> new DrivenAdapterFailedException("REST响应信息不能为空"))
                .validate(responseClass));
    }


    default <S extends ReqTransfer, R extends RespTransfer> Optional<R> post(
            @NotNull RestTemplate restTemplate,
            @NotBlank(message = "REST请求URI不能为空") String url,
            @Valid S request,
            String requestPartName,
            InputStream fileStream,
            @NotBlank(message = "文件名不能为空") String fileName,
            @NotBlank(message = "文件请求体名称不能为空") String filePartName,
            Class<R> responseClass,
            HttpHeaders headers) {

        HttpHeaders requestPartHeaders = new HttpHeaders();
        requestPartHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<S> requestPart = new HttpEntity<>(request, requestPartHeaders);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            byte[] data = new byte[4096];
            int nRead;
            while ((nRead = fileStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException e) {
            throw new DrivenAdapterFailedException("读取文件流失败", e);
        }
        ByteArrayResource fileResource = new ByteArrayResource(buffer.toByteArray()) {
            @Override
            public String getFilename() {
                return fileName;
            }
        };
        HttpHeaders filPartHeaders = new HttpHeaders();
        filPartHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HttpEntity<Resource> filePart = new HttpEntity<>(fileResource, filPartHeaders);

        MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();
        multipartRequest.add(requestPartName, requestPart);
        multipartRequest.add(filePartName, filePart);

        HttpHeaders multipartRequestHeaders = new HttpHeaders();
        multipartRequestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        if (headers != null) {
            multipartRequestHeaders.putAll(headers);
        }

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multipartRequest, multipartRequestHeaders);
        RestResponse<R> restResponse = Optional.ofNullable(
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        httpEntity,
                        new ParameterizedTypeReference<RestResponse<R>>() {
                        }).getBody()
        ).orElseThrow(() -> new DrivenAdapterFailedException("REST响应信息不能为空"));
        return Optional.ofNullable(restResponse.validate(responseClass));
    }
}
