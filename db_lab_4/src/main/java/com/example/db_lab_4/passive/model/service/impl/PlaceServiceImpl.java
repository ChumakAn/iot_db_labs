package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.PlaceDaoImpl;
import com.example.db_lab_4.passive.model.entities.PlaceEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class PlaceServiceImpl  extends AbstractService<PlaceEntity,Integer> implements Service<PlaceEntity, Integer> {
    public PlaceServiceImpl(){
        super(new PlaceDaoImpl());
    }
}
