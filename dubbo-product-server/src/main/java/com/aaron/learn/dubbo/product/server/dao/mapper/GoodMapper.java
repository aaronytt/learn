package com.aaron.learn.dubbo.product.server.dao.mapper;

import com.aaron.learn.base.mapper.CoreMapper;
import com.aaron.learn.dubbo.product.server.dao.po.Good;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 11:15 2019/6/20
 * @Modiflid By:
 */
//@Mapper
public interface GoodMapper extends CoreMapper<Good, Long> {

    @Select("SELECT count(0) FROM goods")
    long getCount();

}
