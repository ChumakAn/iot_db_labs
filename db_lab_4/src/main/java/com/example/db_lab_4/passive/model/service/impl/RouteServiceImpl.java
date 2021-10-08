package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.RouteDaoImpl;
import com.example.db_lab_4.passive.model.entities.RouteEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class RouteServiceImpl  extends AbstractService<RouteEntity,Integer> implements Service<RouteEntity, Integer> {
    public RouteServiceImpl(){
        super(new RouteDaoImpl());
    }
}
