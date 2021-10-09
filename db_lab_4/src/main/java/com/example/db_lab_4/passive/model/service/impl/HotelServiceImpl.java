package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.HotelDaoImpl;
import com.example.db_lab_4.passive.model.entities.HotelEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class HotelServiceImpl extends AbstractService<HotelEntity,Integer> implements Service<HotelEntity, Integer> {
    public HotelServiceImpl(){
        super(new HotelDaoImpl());
    }
}
