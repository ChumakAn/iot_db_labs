package com.example.db_lab_4.passive.controller.impl;


import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.PlaceEntity;
import com.example.db_lab_4.passive.model.service.impl.PlaceServiceImpl;

public class PlaceControllerImpl extends AbstractController<PlaceEntity,Integer> implements Controller<PlaceEntity, Integer> {
    public PlaceControllerImpl(){
        super(new PlaceServiceImpl());
    }

}
