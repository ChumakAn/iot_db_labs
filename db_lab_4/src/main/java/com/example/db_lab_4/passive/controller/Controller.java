package com.example.db_lab_4.passive.controller;

import java.sql.SQLException;
import java.util.List;

public interface Controller<T, K> {
    List<T> findAll() throws SQLException;

    T findById(K id) throws SQLException;

    T create(T entity) throws SQLException;

    T update(K id, T entity) throws SQLException;

    T delete(K id) throws SQLException;
}
