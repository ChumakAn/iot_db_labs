package com.example.db_lab_4.passive.controller.impl;

import com.example.db_lab_4.passive.controller.Controller;
import com.example.db_lab_4.passive.model.service.Service;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<T,K> implements Controller<T,K> {
    private Service<T, K> service;

    public AbstractController(Service<T, K> service) {
        this.service = service;
    }

    @Override
    public List<T> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public T findById(K id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public T create(T entity) throws SQLException {
        return service.create(entity);
    }

    @Override
    public T update(K id, T entity) throws SQLException {
        return service.update(id, entity);
    }

    @Override
    public T delete(K id) throws SQLException {
        return service.delete(id);
    }
}
