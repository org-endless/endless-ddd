package org.endless.ddd.starter.common.model.facade.adapter;


import org.endless.ddd.starter.common.model.common.Adapter;

/**
 * DrivingAdapter
 * <p>主动适配器工厂模版
 * <p>DDD界面层
 * <p>处理其他微服务或限界上下文，访问本微服务或限界上下文资源的逻辑
 * <p>本项目架构设计中，单个微服务包含多个限界上下文，可根据SLA进行重新划分
 * <p>此工厂便于后续扩展实现不同微服务或云计算框架
 * <p>微服务>限界上下文>领域>聚合>实体>值对象
 * <p>目前设计为每个领域一个主动适配器，以便于上下文后续拆分
 * <p>就部署而言上下文是最小单元，领域是业务逻辑最小单元
 * <p>
 * create 2024/08/30 17:36
 * <p>
 * update 2024/08/30 17:36
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface DrivingAdapter extends Adapter {

}
