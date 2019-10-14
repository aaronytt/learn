package com.aaron.learn.spring_core.dao.po;

import com.aaron.learn.base.model.BaseEntity;
import com.aaron.learn.dubbo.all.api.enumeration.OrderState;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Order extends BaseEntity<Long> {

    private String orderNumber;

    private Long customerId;

    private BigDecimal amount;

    private OrderState state;

    private List<SubOrder> subOrderList;

}