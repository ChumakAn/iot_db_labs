package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.Impl.PaymentTypeDaoImpl;
import com.example.db_lab_4.passive.model.entities.PaymentTypeEntity;
import com.example.db_lab_4.passive.model.service.Service;

public class PaymentTypeServiceImpl  extends AbstractService<PaymentTypeEntity,Integer> implements Service<PaymentTypeEntity, Integer> {
    public PaymentTypeServiceImpl(){
        super(new PaymentTypeDaoImpl());
    }
}
