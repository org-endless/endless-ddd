package org.endless.domain.simplified.server.common.model.sidecar.rest;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.AbstractRestResponse;

import java.util.List;

/**
 * DomainSimplifiedServerRestResponse
 * <p>
 * create 2024/09/06 15:28
 * <p>
 * update 2024/09/06 15:29
 *
 * @author Deng Haozhi
 * @see AbstractRestResponse
 * @since 2.0.0
 */
@Getter
@SuperBuilder
public class DomainSimplifiedServerRestResponse extends AbstractRestResponse {


    private static final String SERVICE_DESCRIPTION = "自动化测试平台-服务端";

    @Override
    public void validate() {
    }

    @Override
    public DomainSimplifiedServerRestResponse createInstance(int code, String msg, Object data) {
        return DomainSimplifiedServerRestResponse.builder().code(code).msg(msg).data(data).build();
    }

    @Override
    public DomainSimplifiedServerRestResponse createInstance(int code, String msg, List<Object> rows, Long total) {
        return DomainSimplifiedServerRestResponse.builder().code(code).msg(msg).rows(rows).total(total).build();
    }

    @Override
    public String getServiceDescription() {
        return SERVICE_DESCRIPTION;
    }
}
