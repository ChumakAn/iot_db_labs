package com.example.db_lab_4.passive.controller.impl;


import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.entities.PaymentTypeEntity;
import com.example.db_lab_4.passive.model.service.impl.PaymentTypeServiceImpl;

public class PaymentTypeControllerImpl extends AbstractController<PaymentTypeEntity,Integer> implements Controller<PaymentTypeEntity, Integer> {
    public PaymentTypeControllerImpl(){
        super(new PaymentTypeServiceImpl());
    }
}
