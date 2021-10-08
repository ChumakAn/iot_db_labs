package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.CityDaoImpl;
import com.example.db_lab_4.passive.model.entities.CityEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class CityServiceImpl extends AbstractService<CityEntity,Integer> implements Service<CityEntity, Integer> {
    public CityServiceImpl(){
        super(new CityDaoImpl());
    }
}
