package com.aaron.learn.base.service;

import com.aaron.learn.base.model.BaseEntity;

public interface UpdateBaseService<T extends BaseEntity<ID>, ID>{

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

}
