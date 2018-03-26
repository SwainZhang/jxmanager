package com.emery.test.service.impl;

import com.emery.test.dao.impl.FactoryDaoImpl;
import com.emery.test.domain.Factory;
import com.emery.test.service.FactoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by emery on 2018/3/24.
 */

@Service
public class FactoryServiceImpl implements FactoryService{
    @Autowired
    FactoryDaoImpl mDao;

    public List<Factory> find(Factory entity){
        return mDao.find(entity);
    }
    public  Factory get(Serializable id){
        return mDao.get(id);
    }
    public void insert(Factory entity){
        mDao.insert(entity);
    }
    public void update(Factory entity){
        mDao.update(entity);
    }
    public void delete(Serializable id){
        mDao.delete(id);
    }
    public void delete(Serializable[] id){
        mDao.delete(id);
    }

    public void changeState(Map<String, Object> map) {
        mDao.changeState(map);
    }
}
