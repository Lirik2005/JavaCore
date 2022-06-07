package com.lirik.reflection.test;

import java.lang.reflect.Field;

public class Runner {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        Car opel = new Car("Opel", 120);

        Field model = opel.getClass().getDeclaredField("model");
        model.setAccessible(true);
        model.set(opel, "audi");


        Field[] declaredFields = opel.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Class<?> type = declaredField.getType();

            System.out.println(type + " " + name + " " + declaredField.get(opel));
        }
    }

}
