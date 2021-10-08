package com.example.db_lab_4.passive.controller.impl;

import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.CityEntity;
import com.example.db_lab_4.passive.model.service.impl.CityServiceImpl;

public class CityControllerImpl extends AbstractController<CityEntity,Integer> implements Controller<CityEntity, Integer> {
    public CityControllerImpl(){
        super(new CityServiceImpl());
    }
}
