package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.GuideDaoImpl;
import com.example.db_lab_4.passive.model.entities.GuideEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class GuideServiceImpl  extends AbstractService<GuideEntity,Integer> implements Service<GuideEntity, Integer> {
    public GuideServiceImpl(){
        super( new GuideDaoImpl());
    }
}
