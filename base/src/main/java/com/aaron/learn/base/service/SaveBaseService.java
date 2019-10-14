package com.aaron.learn.base.service;

import com.aaron.learn.base.model.BaseEntity;

public interface SaveBaseService<T extends BaseEntity<ID>, ID>{

    int save(T record);

    int saveSelective(T record);

}
