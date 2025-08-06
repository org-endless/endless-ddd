package org.endless.ddd.starter.common.model.sidecar.rest;

/**
 * RestController
 * <p>Rest控制器模版
 * <p>Service Mesh Sidecar
 * <p>处理外部系统Rest通讯与内部微服务通讯的转换
 * <p>
 * create 2024/09/06 13:51
 * <p>
 * update 2024/09/08 17:54
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface RestController {

    RestResponse response();

}
