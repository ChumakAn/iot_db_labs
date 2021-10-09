package com.example.db_lab_4.passive.controller.impl;

import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.GuideEntity;
import com.example.db_lab_4.passive.model.service.impl.GuideServiceImpl;

public class GuideControllerImpl extends AbstractController<GuideEntity,Integer> implements Controller<GuideEntity, Integer> {
    public GuideControllerImpl(){
        super(new GuideServiceImpl());

    }
}
