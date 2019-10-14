package com.aaron.learn.dubbo.product.server.dao.po;

import com.aaron.learn.base.model.BaseEntity;
import com.aaron.learn.dubbo.all.api.model.GoodDTO;
import lombok.*;

import java.math.BigDecimal;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:14 2019/4/26
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Good extends BaseEntity<Long> {

    private String name;

    private BigDecimal price;

    public GoodDTO toDTO(){
        return GoodDTO.builder().id(getId()).name(name).price(price).createTime(getCreateTime()).updateTime(getUpdateTime()).build();
    }

    public GoodDTO toPO(GoodDTO goodDTO){
        return GoodDTO.builder().id(goodDTO.getId()).name(goodDTO.getName()).price(goodDTO.getPrice()).createTime(goodDTO.getCreateTime()).updateTime(goodDTO.getUpdateTime()).build();
    }

}
