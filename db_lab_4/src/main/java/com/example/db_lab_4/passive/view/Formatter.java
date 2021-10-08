package com.example.db_lab_4.passive.view;

import com.example.db_lab_4.passive.model.manager.EntityManager;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class Formatter<T,K> {
    private EntityManager<T, K> entityManager;

    public Formatter(Class<T> tClass) {
        entityManager = new EntityManager<>(tClass);
    }

    public void formatTable(List<T> entities) {
        try {
            StringBuffer format = new StringBuffer();
            format.append("| ");
            int[] columnLengthes;

            columnLengthes = getColumnLengthes(entities);
            for (int i = 0; i < columnLengthes.length; i++) {
                format.append("%-").append(columnLengthes[i]).append("s | ");
            }
            String[] columns = getColumnNames();
            String formattedNames = String.format(format.toString(), (Object[]) columns);
            String delimitter = formattedNames.replaceAll("[^|]", "-").replace("|", "+");
            delimitter = delimitter.substring(0, delimitter.length() - 1);

            System.out.println(delimitter);
            System.out.println(formattedNames);
            System.out.println(delimitter);
            for (T entity : entities) {
                System.out.println(String.format(format.toString(), (Object[]) propertiesToArray(entity)));
            }
            System.out.println(delimitter);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println("[Error] Exeption while preparing to format data");
            System.out.println("[Error] Message: " + e.getMessage());
        }
    }

    public void formatRow(T entity) {
        List<T> singleEntityList = new LinkedList<T>();
        singleEntityList.add(entity);
        formatTable(singleEntityList);
    }

    private String[] propertiesToArray(T entity) throws IllegalArgumentException, IllegalAccessException {
        Field[] columns = entityManager.getColumns().toArray(new Field[0]);
        String[] properties = new String[columns.length];
        for (int i = 0; i < columns.length; i++) {
            columns[i].setAccessible(true);
            if (columns[i].get(entity) != null) {
                properties[i] = columns[i].get(entity).toString();
            } else {
                properties[i] = "-";
            }
        }
        return properties;
    }

    private String[] getColumnNames() {
        String[] fieldNames = entityManager.getColumnsNames().toArray(new String[0]);
        return fieldNames;
    }

    private int[] getColumnLengthes(List<T> entities) throws IllegalArgumentException, IllegalAccessException {
        Field[] columns = entityManager.getColumns().toArray(new Field[0]);
        int[] lengthes = new int[columns.length];
        for (T entity : entities) {
            for (int i = 0; i < columns.length; i++) {
                if (columns[i].isAnnotationPresent(Column.class)) {
                    columns[i].setAccessible(true);
                    if (columns[i].get(entity) != null) {
                        int fieldLength = columns[i].get(entity).toString().length();
                        lengthes[i] = lengthes[i] < fieldLength ? fieldLength : lengthes[i];
                    }
                }
            }
        }
        String[] fieldNames = getColumnNames();
        for (int i = 0; i < fieldNames.length; i++) {
            int fieldNameLength = fieldNames[i].length();
            lengthes[i] = lengthes[i] < fieldNameLength ? fieldNameLength : lengthes[i];
        }

        return lengthes;
    }
}
