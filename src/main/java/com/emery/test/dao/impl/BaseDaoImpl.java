package com.emery.test.dao.impl;

import com.emery.test.dao.BaseDao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by emery on 2018/3/24.
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {


    private String nameSpace;
    public void setNameSpace(String nameSpace){
        this.nameSpace = nameSpace;
    }
    public String getNameSpace(){
        return  this.nameSpace;
    }

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<T> find(T entity) {
        List<T> data = this.getSqlSession().selectList(getNameSpace()+"find",entity);
        return data;
    }

    public T get(Serializable id) {
        return this.getSqlSession().selectOne(getNameSpace()+"get",id);
    }

    public void insert(T entity) {
        this.getSqlSession().insert(getNameSpace()+"insert",entity);
    }

    public void update(T entity) {
        this.getSqlSession().update(getNameSpace()+"update",entity);
    }

    public void delete(Serializable id) {
        this.getSqlSession().delete(getNameSpace()+"delete");
    }

    public void delete(Serializable[] ids) {
        this.getSqlSession().delete(getNameSpace()+"deleteBatch",ids);
    }
}
