package com.example.db_lab_4.passive.controller.impl;


import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.RouteEntity;
import com.example.db_lab_4.passive.model.service.impl.RouteServiceImpl;

public class RouteControllerImpl extends AbstractController<RouteEntity,Integer> implements Controller<RouteEntity, Integer> {
    public RouteControllerImpl(){
        super(new RouteServiceImpl());
    }
}
