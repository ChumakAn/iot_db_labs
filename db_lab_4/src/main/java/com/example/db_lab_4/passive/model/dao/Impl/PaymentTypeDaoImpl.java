package com.example.db_lab_4.passive.model.dao.Impl;

import com.example.db_lab_4.passive.model.entities.PaymentTypeEntity;

public class PaymentTypeDaoImpl extends AbstractDaoImpl<PaymentTypeEntity, Integer> {
    public PaymentTypeDaoImpl() {
        super(PaymentTypeEntity.class);
    }
}
