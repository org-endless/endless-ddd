package org.endless.ddd.starter.common.ddd.facade.rest;

import org.endless.ddd.starter.common.ddd.facade.adapter.DrivingAdapter;

/**
 * RestController
 * <p>Rest控制器
 * <p>DDD用户界面层
 * <p>用于处理领域外部Rest请求的主动适配器
 * <p>
 * create 2024/09/06 13:51
 * <p>
 * update 2024/09/08 17:54
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface RestController extends DrivingAdapter {

    RestResponse response();

}
