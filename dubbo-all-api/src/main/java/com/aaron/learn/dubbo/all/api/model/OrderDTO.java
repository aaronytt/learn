package com.aaron.learn.dubbo.all.api.model;

import com.aaron.learn.dubbo.all.api.enumeration.OrderState;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:06 2019/10/1
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class OrderDTO implements Serializable {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String orderNumber;

    private Long customerId;

    private BigDecimal amount;

    private OrderState state;

}
