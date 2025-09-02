package org.endless.ddd.starter.common.ddd.common.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * FindPageRespTransfer
 * <p>分页查询响应输对象
 * <p>用于封装分页查询传输数据，可在基础设施层和应用层使用
 * <p>
 * create 2025/01/02 14:08
 * <p>
 * update 2025/01/02 14:15
 *
 * @param rows     查询结果
 * @param total    查询总条数
 * @param pageNum  页码
 * @param pageSize 分页大小
 * @author Deng Haozhi
 * @see Transfer
 * @since 1.0.0
 */
@Builder
@org.endless.ddd.starter.common.annotation.validate.ddd.Transfer
@JSONType(orders = {"rows", "total", "pageSize", "pageNum"})
public record FindPageRespTransfer<R extends RespTransfer>(
        List<R> rows,
        @NotNull(message = "查询总条数不能为空") Long total,
        @NotNull(message = "页码不能为空") Integer pageNum,
        @NotNull(message = "分页大小不能为空") Integer pageSize
) implements Transfer {

    @Override
    public FindPageRespTransfer<R> validate() {
        return this;
    }

    @NotNull(message = "查询结果不能为空对象")
    public List<R> getRows(
            @NotNull(message = "查询结果对象类型不能为空") Class<R> clazz) {
        return Optional.ofNullable(rows)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElse(Collections.emptyList())
                .stream()
                .map(t -> ObjectTools.of(t, clazz))
                .toList();
    }
}
