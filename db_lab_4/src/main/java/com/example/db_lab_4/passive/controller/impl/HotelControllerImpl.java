package com.example.db_lab_4.passive.controller.impl;


import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.HotelEntity;
import com.example.db_lab_4.passive.model.service.impl.HotelServiceImpl;

public class HotelControllerImpl extends AbstractController<HotelEntity,Integer> implements Controller<HotelEntity, Integer> {
    public HotelControllerImpl(){
        super(new HotelServiceImpl());
    }
}
