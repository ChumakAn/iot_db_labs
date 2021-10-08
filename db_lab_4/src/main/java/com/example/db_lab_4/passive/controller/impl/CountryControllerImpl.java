package com.example.db_lab_4.passive.controller.impl;

import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.CountryEntity;
import com.example.db_lab_4.passive.model.service.impl.CountryServiceImpl;

public class CountryControllerImpl extends AbstractController<CountryEntity,Integer> implements Controller<CountryEntity, Integer> {
    public CountryControllerImpl(){
        super(new CountryServiceImpl());
    }
}
