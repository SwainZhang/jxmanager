package com.emery.test.dao;

import com.emery.test.domain.Factory;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by emery on 2018/3/24.
 */
@Repository
public interface FactoryDao extends BaseDao<Factory> {
    void changeState(Map<String,Object> map);
}
