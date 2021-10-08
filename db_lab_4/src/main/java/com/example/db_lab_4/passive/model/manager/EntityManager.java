package com.example.db_lab_4.passive.model.manager;

import com.example.db_lab_4.passive.model.annotations.InputIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor

public class EntityManager<T, K>{
    private final Class<T> tClass;
    private final Field[] fields;

    public EntityManager(Class<T> tClass) {
        this.tClass = tClass;
        this.fields = tClass.getDeclaredFields();
    }

    public Class<T> getEntityClass() {
        return tClass;
    }

    public Field[] getEntityFields() {
        return fields.clone();
    }

    public String getTableName() {
        Table table = tClass.getAnnotation(Table.class);
        String tableName = table.name();
        return tableName;
    }

    public String getPrimaryKeyName() {
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                return field.getAnnotation(Column.class).name();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public K getPrimaryKeyValue(T entity) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                return (K) field.get(entity);
            }
        }
        return null;
    }

    public List<String> getColumnsNamesInput() {
        List<String> columnsNames = new LinkedList<>();
        List<Field> columns = getColumnsInput();
        for (Field field : columns) {
            columnsNames.add(field.getAnnotation(Column.class).name());
        }
        return columnsNames;
    }

    public List<Field> getColumnsInput() {
        List<Field> inputColumns = new LinkedList<>();
        List<Field> columns = getColumns();
        for (Field field : columns) {
            if (!field.isAnnotationPresent(Id.class) && !field.isAnnotationPresent(InputIgnore.class)) {
                inputColumns.add(field);
            }
        }
        return inputColumns;
    }

    public List<String> getColumnsNames() {
        List<String> columnsNames = new LinkedList<String>();
        List<Field> columns = getColumns();
        for (Field field : columns) {
            columnsNames.add(field.getAnnotation(Column.class).name());
        }
        return columnsNames;
    }

    public List<Field> getColumns() {
        List<Field> columns = new LinkedList<Field>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                columns.add(field);
            }
        }
        return columns;
    }

    public String generateColumnsNamesString() {
        List<String> columns = getColumnsNamesInput();
        String columnsNamesString = String.join(",", columns);
        return columnsNamesString;
    }

    public String generateColumnsParametersString() {
        List<String> columns = getColumnsNamesInput();
        columns.replaceAll(s -> s = "?");
        String columnsParameters = String.join(",", columns);
        return columnsParameters;
    }

    public String generateUpdateColumnsString() {
        List<String> columns = getColumnsNamesInput();
        columns.replaceAll(s -> s += "=?");
        String updateColumnsString = String.join(",", columns);
        return updateColumnsString;
    }

    public T setFieldByName(T entity, String fieldName, Object fieldValue)
            throws IllegalArgumentException, IllegalAccessException {
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                field.set(entity, fieldValue);
                break;
            }
        }
        return entity;
    }
}
