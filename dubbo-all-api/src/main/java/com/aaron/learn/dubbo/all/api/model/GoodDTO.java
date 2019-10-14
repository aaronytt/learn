package com.aaron.learn.dubbo.all.api.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:59 2019/9/28
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class GoodDTO implements Serializable {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String name;

    private BigDecimal price;

}
