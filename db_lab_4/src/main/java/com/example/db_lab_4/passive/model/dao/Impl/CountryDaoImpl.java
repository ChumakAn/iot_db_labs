package com.example.db_lab_4.passive.model.dao.Impl;

import com.example.db_lab_4.passive.model.entities.CountryEntity;

public class CountryDaoImpl extends AbstractDaoImpl<CountryEntity,Integer>  {

    public CountryDaoImpl() {
        super(CountryEntity.class);
    }
}
