package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.TransportTypeDaoImpl;
import com.example.db_lab_4.passive.model.entities.TransportTypeEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class TransportTypeServiceImpl  extends AbstractService<TransportTypeEntity,Integer> implements Service<TransportTypeEntity, Integer> {
    public TransportTypeServiceImpl(){
        super(new TransportTypeDaoImpl());
    }
}
