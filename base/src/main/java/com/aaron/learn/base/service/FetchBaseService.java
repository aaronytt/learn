package com.aaron.learn.base.service;

import com.aaron.learn.base.model.BaseEntity;

import java.util.List;

public interface FetchBaseService<T extends BaseEntity<ID>, ID>{

    T fetchByID(ID id);

    List<T> fetchSelective(T record);

}
