package com.example.db_lab_4.passive.model.service.impl;


import com.example.db_lab_4.passive.model.dao.Impl.CountryDaoImpl;
import com.example.db_lab_4.passive.model.entities.CountryEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class CountryServiceImpl  extends AbstractService<CountryEntity,Integer> implements Service<CountryEntity, Integer> {
    public CountryServiceImpl(){
        super(new CountryDaoImpl());
    }
}
