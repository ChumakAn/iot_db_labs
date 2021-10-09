package com.example.db_lab_4.passive.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T, K> {
    List<T> findAll() throws SQLException;

    T findById(K id) throws SQLException;

    int create(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(K id) throws SQLException;
}