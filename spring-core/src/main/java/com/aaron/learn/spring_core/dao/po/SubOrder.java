package com.aaron.learn.spring_core.dao.po;

import com.aaron.learn.base.model.BaseEntity;
import com.aaron.learn.dubbo.all.api.enumeration.OrderState;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SubOrder extends BaseEntity<Long> {

    private String orderNumber;

    private String subOrderNumber;

    private BigDecimal amount;

    private OrderState state;

    private Long goodId;

    private Integer quantity;

    private static final long serialVersionUID = 1L;
}