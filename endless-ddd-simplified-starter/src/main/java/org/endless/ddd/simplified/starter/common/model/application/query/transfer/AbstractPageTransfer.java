package org.endless.ddd.simplified.starter.common.model.application.query.transfer;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * AbstractDrivingPageTransfer
 * <p>
 * create 2024/09/10 10:41
 * <p>
 * update 2024/09/10 12:18
 *
 * @author Deng Haozhi
 * @see PageTransfer
 * @since 2.0.0
 */
@Getter
@SuperBuilder
public abstract class AbstractPageTransfer implements PageTransfer {

    private final List<Object> rows;

    private final Long total;

    private final Integer pageSize;

    private final Integer pageNum;

    protected AbstractPageTransfer(AbstractPageTransferBuilder<?, ?> builder) {

        this.rows = builder.rows;
        this.total = builder.total;
        this.pageSize = builder.pageSize;
        this.pageNum = builder.pageNum;

        validateTemplate();
    }

    @Override
    public void validateTemplate() {
        validate();
    }
}
