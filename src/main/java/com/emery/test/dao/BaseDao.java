package com.emery.test.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T>{
    List<T> find(T entity);
    T get(Serializable id);
    void insert(T entity);
    void update(T entity);
    void delete(Serializable id);
    void delete(Serializable[] id);
}