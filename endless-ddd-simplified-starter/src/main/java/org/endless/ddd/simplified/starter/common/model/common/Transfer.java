package org.endless.ddd.simplified.starter.common.model.common;

import java.io.Serializable;

/**
 * Transfer
 * <p>DDD-DTO类型模版
 * <p>
 * create 2024/09/03 11:44
 * <p>
 * update 2024/09/03 11:46
 *
 * @author Deng Haozhi
 * @see Serializable
 * @since 2.0.0
 */
public interface Transfer extends Serializable {

    Transfer validate();
}
