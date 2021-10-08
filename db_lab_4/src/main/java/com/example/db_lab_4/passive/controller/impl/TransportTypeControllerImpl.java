package com.example.db_lab_4.passive.controller.impl;


import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.TransportTypeEntity;
import com.example.db_lab_4.passive.model.service.impl.TransportTypeServiceImpl;

public class TransportTypeControllerImpl extends AbstractController<TransportTypeEntity,Integer> implements Controller<TransportTypeEntity, Integer> {
    public TransportTypeControllerImpl(){
        super(new TransportTypeServiceImpl());
    }
}
