package com.aaron.learn.base.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:52 2019/4/26
 * @Modiflid By:
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

    private T id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    
}
