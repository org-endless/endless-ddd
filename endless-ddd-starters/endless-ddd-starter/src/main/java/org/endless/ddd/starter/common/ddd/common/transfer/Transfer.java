package org.endless.ddd.starter.common.ddd.common.transfer;

import java.io.Serializable;

/**
 * Transfer
 * <p>传输对象
 * <p>
 * create 2024/09/03 11:44
 * <p>
 * update 2024/09/03 11:46
 *
 * @author Deng Haozhi
 * @see Serializable
 * @since 1.0.0
 */
public interface Transfer extends Serializable {

    Transfer validate();
}
