package com.example.db_lab_4.passive.model.dao.Impl;

import com.example.db_lab_4.passive.model.dao.AbstractDao;
import com.example.db_lab_4.passive.model.entities.CityEntity;
import com.example.db_lab_4.passive.model.manager.EntityManager;
import com.example.db_lab_4.passive.model.persistant.ConnectionManager;
import com.example.db_lab_4.passive.model.transformer.Transformer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor

public abstract class AbstractDaoImpl<T,K> implements AbstractDao<T,K> {
    private static final String FIND_ALL_TEMPLATE = "SELECT * FROM %s";
    private static final String FIND_BY_ID_TEMPLATE = "SELECT * FROM %s WHERE %s=?";
    private static final String POST_TEMPLATE = "INSERT %s (%s) VALUES (%s)";
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET %s WHERE %s=?";
    private static final String DELETE_TEMPLATE = "DELETE FROM %s WHERE %s=?";

    private static final String ERROR_EXCEPTION_TEMPLATE = "[Error] Exeption while %s";
    private static final String ERROR_MESSAGE_TEMPLATE = "[Error] Message: %s";

    private Class<T> tClass;
    private Transformer<T, K> entityTransformer;
    private EntityManager<T, K> entityManager;

    public AbstractDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
        this.entityManager = new EntityManager<T, K>(tClass);
        this.entityTransformer = new Transformer<T, K>(tClass);
    }

    @Override
    public List<T> findAll() throws SQLException{
        List<T> entityList = new LinkedList<>();
         if (tClass.isAnnotationPresent(Table.class)){
             Connection connection = ConnectionManager.getConnection();
             String tableName = entityManager.getTableName();
             String sql = String.format(FIND_ALL_TEMPLATE, tableName);
             try (PreparedStatement ps = connection.prepareStatement(sql)) {
                 try (ResultSet resultSet = ps.executeQuery()) {
                     while (resultSet.next()) {
                         entityList.add(entityTransformer.fromResultSetToEntity(resultSet));
                     }
                 } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                         | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                     System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "transforming data into objects"));
                     System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
                 }
             }
         }
         return entityList;
    }

    @Override
    public T findById(K id) throws SQLException {

        String tableName = entityManager.getTableName();
        String primaryKeyName = entityManager.getPrimaryKeyName();
        List<T> entities = findByField(tableName, primaryKeyName, id);
        if (entities.size() > 0) {
            return entities.get(0);
        } else {
            return null;
        }
    }
    private List<T> findByField(String tableName, String fieldName, Object fieldValue) throws SQLException {
        List<T> entityList = new LinkedList<T>();

        if (tClass.isAnnotationPresent(Table.class)) {
            Connection connection = ConnectionManager.getConnection();
            String sql = String.format(FIND_BY_ID_TEMPLATE, tableName, fieldName);
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                boolean isValueSet = entityTransformer.setPreparedStatementWithType(1, ps, fieldValue);
                if (isValueSet == false) {
                    return null;
                }

                try (ResultSet resultSet = ps.executeQuery()) {
                    while (resultSet.next()) {
                        entityList.add(entityTransformer.fromResultSetToEntity(resultSet));
                    }
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "transforming data into objects"));
                    System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
                }
            }
        }

        return entityList;
    }
    @Override
    public int create(T entity) throws SQLException {

        if (tClass.isAnnotationPresent(Table.class)) {

            String tableName = entityManager.getTableName();
            String columnsNamesString = entityManager.generateColumnsNamesString();
            String columnsParameters = entityManager.generateColumnsParametersString();

            Connection connection = ConnectionManager.getConnection();
            String sql = String.format(POST_TEMPLATE, tableName, columnsNamesString, columnsParameters);

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                entityTransformer.fillInColumnsInPreparedStatement(1, ps, entity);
                return ps.executeUpdate();
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "preparing SQL query for INSERT"));
                System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
            }

        }
        return 0;
    }

    @Override
    public int update(T entity) throws SQLException {

        if (tClass.isAnnotationPresent(Table.class)) {

            try {

                String tableName = entityManager.getTableName();
                String updateColumnsString = entityManager.generateUpdateColumnsString();
                String primaryKeyName = entityManager.getPrimaryKeyName();
                K primaryKeyValue = entityManager.getPrimaryKeyValue(entity);

                Connection connection = ConnectionManager.getConnection();
                String sql = String.format(UPDATE_TEMPLATE, tableName, updateColumnsString, primaryKeyName);

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    int nextFreeIndex;
                    nextFreeIndex = entityTransformer.fillInColumnsInPreparedStatement(1, ps, entity);
                    boolean isValueSet = entityTransformer.setPreparedStatementWithType(nextFreeIndex, ps, primaryKeyValue);
                    if (isValueSet == false) {
                        return 0;
                    }
                    return ps.executeUpdate();
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "preparing SQL query for UPDATE"));
                System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
            }

        }

        return 0;
    }

    @Override
    public int delete(K id) throws SQLException {

        if (tClass.isAnnotationPresent(Table.class)) {

            String tableName = entityManager.getTableName();
            String primaryKeyName = entityManager.getPrimaryKeyName();

            Connection connection = ConnectionManager.getConnection();
            String sql = String.format(DELETE_TEMPLATE, tableName, primaryKeyName);

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                boolean isValueSet = entityTransformer.setPreparedStatementWithType(1, ps, id);
                if (isValueSet == false) {
                    return 0;
                }
                return ps.executeUpdate();
            }

        }

        return 0;
    }

    protected List<T> findByInteger(String tableName, String fieldName, Integer fieldValue) throws SQLException {
        return findByField(tableName, fieldName, fieldValue);
    }


}