package com.lirik.reflection.practice.task01.version2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Создать класс Car с полями String brand и String model. Создать аннотации @Table (принимает название схемы и таблицы в базе данных)
 * и @Column (принимает название колонки в таблице базы данных). Пометить класс аннотацией @Table и поля аннотацией @Column. Написать
 * программу, принимающую объект класс  Car c проинициализированными полями и составляющую запрос "INSERT" в виде строки на основании
 * данных объекта.
 * Пример: дан объект Car car = new Car("Toyota", "Corolla"); Программа, принимающая этот объект, должна вывести в консоль строку:
 * "INSERT INTO garage.car (model, brand) VALUES ('Toyota', 'Corolla');"
 * <p>
 * В этом решении мы вызываем МЕТОДЫ, А НЕ ПОЛЯ!!!
 */

public class CarRunner {

    public static void main(String[] args) {
       Car car = new Car("Toyota", "Corolla");
        System.out.println(car);
        System.out.println();
        System.out.println(generateInsert(car));
    }

    private static String generateInsert(Car car) {
        String template = "INSERT INTO %s.%s (%s) VALUES (%s);";
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();

        String fieldsNames = Arrays.stream(fields)
                                   .filter(field -> field.isAnnotationPresent(Column.class))
                                   .map(field -> field.getAnnotation(Column.class))
                                   .map(column -> column.name())
                                   .collect(Collectors.joining(", "));

        String fieldsValues = Arrays.stream(fields)
                                    .filter(field -> field.isAnnotationPresent(Column.class))
                                    .map(field -> getMethodName(car, field))
                .map(method -> {
                    try {
                        return method.invoke(car);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                                    .map(value -> "'" + value + "'")
                                    .collect(Collectors.joining(", "));

        return String.format(template, table.schema(), table.name(), fieldsNames, fieldsValues);

    }

    private static Method getMethodName(Car car, Field field) {
        try {
            return car.getClass().getMethod(
                    "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }
}
