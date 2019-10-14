package com.aaron.learn.base.service;

import com.aaron.learn.base.model.BaseEntity;

public interface DeleteBaseService<T extends BaseEntity<ID>, ID>{

    int deleteByID(ID id);

}
