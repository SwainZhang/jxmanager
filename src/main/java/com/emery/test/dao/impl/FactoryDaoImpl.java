package com.emery.test.dao.impl;

import com.emery.test.dao.FactoryDao;
import com.emery.test.domain.Factory;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by emery on 2018/3/24.
 */
@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {


    public FactoryDaoImpl() {
        this.setNameSpace("com.emery.test.mapper.FactoryMapper.");
    }


    public void changeState(Map<String, Object> map) {
        getSqlSession().update(getNameSpace()+"update",map);
    }
}
