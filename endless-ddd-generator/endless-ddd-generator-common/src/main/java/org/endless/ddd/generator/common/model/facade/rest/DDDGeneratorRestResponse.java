package org.endless.ddd.generator.common.model.facade.rest;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.endless.ddd.starter.common.config.rest.response.AbstractRestResponse;

/**
 * DDDGeneratorRestResponse
 * <p>
 * create 2024/09/06 15:28
 * <p>
 * update 2024/09/06 15:29
 *
 * @author Deng Haozhi
 * @see AbstractRestResponse
 * @since 1.0.0
 */
@Getter
@SuperBuilder
public class DDDGeneratorRestResponse extends AbstractRestResponse {

    private static final String SERVICE_DESCRIPTION = "DDD代码生成器";

    @Override
    public DDDGeneratorRestResponse createInstance(String status, String errorCode, String message, Object data) {
        return DDDGeneratorRestResponse.builder().status(status).errorCode(errorCode).message(message).data(data).build();
    }

    @Override
    public String getServiceDescription() {
        return SERVICE_DESCRIPTION;
    }
}
