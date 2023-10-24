package com.k1.Parcial.domain.service.servicesImpl;

import java.lang.reflect.Field;

public class MetodosComunes {
    public static <T> T noUpdateToFieldsNull(T newDate, T toUpdate) {
        Field[] fields = newDate.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                Object value = field.get(newDate);
                if (value != null) {
                    field.set(toUpdate, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return toUpdate;
    }
}


