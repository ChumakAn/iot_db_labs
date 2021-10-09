package com.example.db_lab_4.passive.model.service.impl;

import com.example.db_lab_4.passive.model.dao.AbstractDao;
import com.example.db_lab_4.passive.model.service.Service;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractService<T,K> implements Service<T,K> {
    private final AbstractDao<T, K> dataAccess;

    public AbstractService(AbstractDao<T, K> dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> foundEntities = dataAccess.findAll();
        if (foundEntities.size() > 0) {
            return foundEntities;
        } else {
            return null;
        }
    }

    @Override
    public T findById(K id) throws SQLException {
        return dataAccess.findById(id);
    }

    @Override
    public T create(T entity) throws SQLException {
        int newEntitiesCount = dataAccess.create(entity);
        T newEntity = null;
        if (newEntitiesCount > 0) {
            List<T> entities = findAll();
            newEntity = entities.get(entities.size() - 1);
        }
        return newEntity;
    }

    @Override
    public T update(K id, T entity) throws SQLException {
        T oldEntity = findById(id);
        int updatedEntitiesCount = dataAccess.update(entity);
        if (updatedEntitiesCount > 0) {
            return oldEntity;
        }
        return null;
    }

    @Override
    public T delete(K id) throws SQLException {
        T oldEntity = findById(id);
        int deletedEntitiesCount = dataAccess.delete(id);
        if (deletedEntitiesCount > 0) {
            return oldEntity;
        }
        return null;
    }
}
